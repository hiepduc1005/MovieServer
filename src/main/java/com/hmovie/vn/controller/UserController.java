package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.response.UserCreatedDateResponse;
import com.hmovie.vn.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/created-date")
    public ResponseEntity<UserCreatedDateResponse> getUserCreatedDate() {
 
        String createdDate = userService.getCreatedDate();
        UserCreatedDateResponse response = new UserCreatedDateResponse(createdDate);

        return ResponseEntity.ok(response);

    }
    
    @GetMapping("/me")
    public ResponseEntity<String> getUser() {

    	return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
