package com.hmovie.vn.dto.response;

public class UserAuthResponse {
	private String token;
	private String type;
	
	
	public UserAuthResponse(String token) {
		this.token = token;
		this.type = "Bearer";
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
