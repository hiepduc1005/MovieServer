package com.hmovie.vn.security.oauth2;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.hmovie.vn.entity.Provider;

public class DefaultOauth2User implements OAuth2User {
	
	private OAuth2User oAuth2User;
	private Provider provider;
	

	public DefaultOauth2User(OAuth2User oAuth2User,Provider provider) {
		this.oAuth2User = oAuth2User;
	}
	
	

	public OAuth2User getoAuth2User() {
		return oAuth2User;
	}



	public void setoAuth2User(OAuth2User oAuth2User) {
		this.oAuth2User = oAuth2User;
	}



	public Provider getProvider() {
		return provider;
	}



	public void setProvider(Provider provider) {
		this.provider = provider;
	}



	@Override
	public Map<String, Object> getAttributes() {
		return oAuth2User.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return oAuth2User.getAuthorities();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return oAuth2User.getAttribute("name");
	}
	

	public String getEmail() {
		// TODO Auto-generated method stub
		return oAuth2User.getAttribute("email");
	}
	

}
