package com.hmovie.vn.security.oauth2;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.hmovie.vn.entity.Provider;
import com.hmovie.vn.entity.User;
import com.hmovie.vn.security.JWTGenerator;
import com.hmovie.vn.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Oauth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public JWTGenerator jwtGenerator;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		OAuth2AuthenticationToken auth2AuthenticationToken = (OAuth2AuthenticationToken)authentication;
		DefaultOauth2User oauth2User = (DefaultOauth2User)authentication.getPrincipal();
		String email = oauth2User.getEmail();
		String username = oauth2User.getName();
		Provider provider = Provider.valueOf(auth2AuthenticationToken.getAuthorizedClientRegistrationId().toUpperCase());
		
		String avatarUrl = null;
		 if (provider == Provider.FACEBOOK) {
	            @SuppressWarnings("unchecked")
				Map<String, Object> pictureObj = (Map<String, Object>) oauth2User.getAttribute("picture");
	            if (pictureObj != null) {
	                @SuppressWarnings("unchecked")
					Map<String, Object> data = (Map<String, Object>) pictureObj.get("data");
	                if (data != null) {
	                    avatarUrl = (String) data.get("url");
	                }
	            }
	        } else if (provider == Provider.GOOGLE) {
	            avatarUrl = oauth2User.getAttribute("picture");
	    }
		
		User user = userService.findUserByEmail(email);
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setUsername(username);
            user.setAvatarUrl(avatarUrl);
            user.setProvider(provider);
            userService.createUser(user);
        } else {
            user.setAvatarUrl(avatarUrl); 
            userService.updateUser(user);
        }
        
		String token = jwtGenerator.gennerateToken(authentication);
		
	    String encodedToken = URLEncoder.encode(Base64.getEncoder().encodeToString(token.getBytes()), StandardCharsets.UTF_8.toString());
		
        String redirectUrl = "https://hmovie1005.netlify.app" + "?t=" + encodedToken;
        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
		super.onAuthenticationSuccess(request, response, authentication);
		
	}
	
	
}
