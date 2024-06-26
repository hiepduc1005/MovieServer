package com.hmovie.vn.service.convert;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmovie.vn.dto.request.Auth.UserSignUpRequest;
import com.hmovie.vn.dto.response.MovieResponse;
import com.hmovie.vn.dto.response.UserResponse;
import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.entity.User;
import com.hmovie.vn.entity.WatchList;

@Service
public class UserConvert {
	
	@Autowired
	public MovieConvert movieConvert;

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
    	
    	WatchList watchList = user.getWatchList();
    	List<Movie> movies = watchList.getMovies();
    	List<MovieResponse> movieResponses = new ArrayList<MovieResponse>();
    	if(!movies.isEmpty()) {  		
    	   movieResponses = movies.stream().map(movie -> movieConvert.movieConvertToMovieResponse(movie)).toList();
    	}    	
    	   	
    	return new UserResponse(
    			user.getId(),
    			user.getUsername(),
    			user.getEmail(),
    			user.getProvider(),
    			user.getAvatarUrl(),
    			user.getCreatedAt(),
    			user.getRole(), 
    			movieResponses);
    }
    


 
}
