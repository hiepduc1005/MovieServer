package com.hmovie.vn.service.convert;


import org.springframework.stereotype.Service;

import com.hmovie.vn.dto.request.Auth.UserSignUpRequest;
import com.hmovie.vn.entity.User;

@Service
public class UserConvert {

    public User userSignUpRequestConvertToUser(UserSignUpRequest userSignUpRequest) {
        if (userSignUpRequest == null) {
            return null;
        }

        User user = new User();
        user.setUsername(userSignUpRequest.getUsername());
        user.setEmail(userSignUpRequest.getEmail());
        user.setPassword(userSignUpRequest.getPassword());

        return user;
    }


 
}
