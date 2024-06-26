package com.hmovie.vn.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmovie.vn.entity.Role;
import com.hmovie.vn.entity.User;
import com.hmovie.vn.entity.WatchList;
import com.hmovie.vn.repository.UserRepository;
import com.hmovie.vn.service.UserService;
import com.hmovie.vn.service.WatchListService;

@Service
public class DefaultUserService implements UserService {

	
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public WatchListService watchListService;
    
    public static String getCurrenDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return now.format(dateTimeFormatter);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        if (user.getId() != null) {
            throw new RuntimeException("User already exist!");
        }
        
        String email = user.getEmail();
		if(email.isEmpty() || email == null) {
			throw new RuntimeException("Email must not be null or empty!");
		}
		
		if(userRepository.findByEmail(email) != null) {
			throw new RuntimeException("User with email :" + email + " already exist!");
		}
		
		user.setRole(Role.ROLE_USER);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = user.getPassword();
		
		String encryptPassword = (password == null || password.isEmpty()) ? "" : passwordEncoder.encode(password);
		
		user.setPassword(encryptPassword);
		
        WatchList watchList = watchListService.createWatchList();
        user.setWatchList(watchList);
        user.setCreatedAt(getCurrenDateTime());

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        if (userId == null || userId <= 0) {
            throw new RuntimeException("User id must not be null and must be positive");
        }

        userRepository.deleteById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public String getCreatedDate() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email);

        String createdDate = "";
        if (user != null) {
            createdDate = user.getCreatedAt();
        } else {
            throw new RuntimeException("Not found user with email : " + email);
        }

        return createdDate;
    }

    @Override
    @Transactional
    public User updateUser(User userUpdate) {
        if (userUpdate.getId() == null) {
            throw new RuntimeException("User not exist!");
        }

        return userRepository.save(userUpdate);
    }

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}


}
