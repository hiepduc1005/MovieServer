package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.response.UserCreatedDateResponse;
import com.hmovie.vn.dto.response.UserResponse;
import com.hmovie.vn.entity.User;
import com.hmovie.vn.service.UserService;
import com.hmovie.vn.service.convert.UserConvert;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    public UserService userService;
    
    @Autowired
    public UserConvert userConvert;

    @GetMapping("/created-date")
    public ResponseEntity<UserCreatedDateResponse> getUserCreatedDate() {
 
        String createdDate = userService.getCreatedDate();
        UserCreatedDateResponse response = new UserCreatedDateResponse(createdDate);

        return ResponseEntity.ok(response);

    }
    
    @GetMapping("/me")
    public ResponseEntity<UserResponse> getUser() {
    	String email = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findUserByEmail(email);
  
    	return ResponseEntity.ok(userConvert.userConvertToUserResponse(user));
    }

}
