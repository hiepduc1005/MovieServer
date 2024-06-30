package com.hmovie.vn.dto.response;

import java.util.List;

import com.hmovie.vn.entity.Provider;
import com.hmovie.vn.entity.Role;


public class UserResponse {
	private Integer id;
	private String username;
	private String email;
	private Provider provider;
	private String avatarUrl;
	private String createdAt;
	private Role role;
	private WatchListResponse watchList;
	private List<WatchHistoryResponse> watchHistoryResponses;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	public WatchListResponse getWatchList() {
		return watchList;
	}
	public void setWatchList(WatchListResponse watchList) {
		this.watchList = watchList;
	}
	
	public List<WatchHistoryResponse> getWatchHistoryResponses() {
		return watchHistoryResponses;
	}
	public void setWatchHistoryResponses(List<WatchHistoryResponse> watchHistoryResponses) {
		this.watchHistoryResponses = watchHistoryResponses;
	}
	public UserResponse(Integer id, String username, String email, Provider provider, String avatarUrl,
			String createdAt, Role role, WatchListResponse watchList,
			List<WatchHistoryResponse> watchHistoryResponses) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.provider = provider;
		this.avatarUrl = avatarUrl;
		this.createdAt = createdAt;
		this.role = role;
		this.watchList = watchList;
		this.watchHistoryResponses = watchHistoryResponses;
	}
	
	
}
