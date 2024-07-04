package com.hmovie.vn.security.oauth2;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
import jakarta.servlet.http.Cookie;
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
		String avatarUrl = oauth2User.getAttribute("picture");
		
		User user = userService.findUserByEmail(email);
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setUsername(username);
            user.setAvatarUrl(avatarUrl);
            user.setProvider(provider);
            userService.createUser(user);
        } else {
            user.setAvatarUrl(avatarUrl); // Cập nhật avatar nếu người dùng đã tồn tại
            userService.updateUser(user);
        }
        
		String token = jwtGenerator.gennerateToken(authentication);
		
	    String encodedToken = URLEncoder.encode(Base64.getEncoder().encodeToString(token.getBytes()), StandardCharsets.UTF_8.toString());
		
        String redirectUrl = "https://hmovie1005.netlify.app" + "?t=" + encodedToken;
        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
		super.onAuthenticationSuccess(request, response, authentication);
		
	}
	
	
}
