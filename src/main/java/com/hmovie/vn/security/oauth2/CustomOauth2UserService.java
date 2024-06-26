package com.hmovie.vn.security.oauth2;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.hmovie.vn.entity.Provider;

@Service
public class CustomOauth2UserService extends DefaultOAuth2UserService{

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User auth2User = super.loadUser(userRequest);
		String reregistrationId = userRequest.getClientRegistration().getRegistrationId();
		Provider provider = Provider.valueOf(reregistrationId.toUpperCase());
		return new DefaultOauth2User(auth2User , provider);
	}
	
	
	
}
