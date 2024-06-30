package com.hmovie.vn.service.convert;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmovie.vn.dto.request.Auth.UserSignUpRequest;
import com.hmovie.vn.dto.response.UserResponse;
import com.hmovie.vn.dto.response.WatchHistoryResponse;
import com.hmovie.vn.dto.response.WatchListResponse;
import com.hmovie.vn.entity.User;

@Service
public class UserConvert {
	
	@Autowired
	public MovieConvert movieConvert;
	
	@Autowired
	public WatchHistoryConvert watchHistoryConvert;
	
	@Autowired
	public WatchListConvert watchListConvert;

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
    
    public UserResponse userConvertToUserResponse(User user) {
    	if(user == null) {
    		return null;
    	}
    	
    	
    	List<WatchHistoryResponse> historyResponses = user.getWatchHistory()
    			.stream().map(wh -> watchHistoryConvert.watchHistoryConvertToWatchHistoryResponse(wh)).toList();
    	
    	WatchListResponse watchListResponse =watchListConvert.watchListConvertToWatchListResponse(user.getWatchList());
    	
    	return new UserResponse(
    			user.getId(),
    			user.getUsername(),
    			user.getEmail(),
    			user.getProvider(),
    			user.getAvatarUrl(),
    			user.getCreatedAt(),
    			user.getRole(), 
    			watchListResponse,
    			historyResponses
    			);
    }
    


 
}
