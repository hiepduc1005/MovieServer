package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

}
