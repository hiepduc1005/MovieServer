package com.hmovie.vn.service;

import com.hmovie.vn.entity.User;

public interface UserService {
	

	User createUser(User user);

	User updateUser(User userUpdate);

	void deleteUser(Integer userId);

	String getCreatedDate();
	
	User findUserByEmail(String email);
	
	User findUserById(Integer userId);
}
