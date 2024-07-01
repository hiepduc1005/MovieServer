package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.request.Auth.UserAuthRequest;
import com.hmovie.vn.dto.request.Auth.UserSignUpRequest;
import com.hmovie.vn.dto.response.UserAuthResponse;
import com.hmovie.vn.entity.Provider;
import com.hmovie.vn.entity.User;
import com.hmovie.vn.security.JWTGenerator;
import com.hmovie.vn.service.EmailValidator;
import com.hmovie.vn.service.UserService;
import com.hmovie.vn.service.convert.UserConvert;

import jakarta.security.auth.message.AuthException;

@RequestMapping("api/v1/auth")
@RestController
public class AuthController {

    @Autowired
    public UserService userService;

    @Autowired
    public UserConvert userConvert;
    
    @Autowired
    public AuthenticationManager authenticationManager;
    
    @Autowired
    public JWTGenerator jwtGenerator;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody UserSignUpRequest signUpRequest) {
        User user = userConvert.userSignUpRequestConvertToUser(signUpRequest);
        user.setProvider(Provider.HMOVIE);
        userService.createUser(user);

        return ResponseEntity.ok("Create user success full");
    }
    
    @PostMapping("/login")
    public ResponseEntity<UserAuthResponse> login(@RequestBody UserAuthRequest userAuthRequest) throws AuthException{
    	String email = userAuthRequest.getEmail();
    	
    	if(!EmailValidator.isValidEmail(email)) {
    		throw new AuthException("Invalid email"); 
    	}
    	
    	if(userService.findUserByEmail(email) == null) {
    		throw new AuthException("User with email: " + email + " dont exist!" ); 
    	}
    	
    	Authentication authentication = authenticationManager.authenticate(
    			new UsernamePasswordAuthenticationToken(
    					userAuthRequest.getEmail(),
    					userAuthRequest.getPassword()
    					));
    	
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	
    	
    	String token = jwtGenerator.gennerateToken(authentication);
    	return ResponseEntity.ok(new UserAuthResponse(token));
    }
    
}
