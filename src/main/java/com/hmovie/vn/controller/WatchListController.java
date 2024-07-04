package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.request.watchlist.WatchListAddMovieRequest;
import com.hmovie.vn.dto.response.WatchListResponse;
import com.hmovie.vn.entity.User;
import com.hmovie.vn.service.UserService;
import com.hmovie.vn.service.WatchListService;
import com.hmovie.vn.service.convert.WatchListConvert;

@RestController
@RequestMapping("api/v1/watchlist")
public class WatchListController {
	
	@Autowired
	public WatchListService watchListService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public WatchListConvert watchListConvert;
	
	@GetMapping("/check")
    public ResponseEntity<Boolean> checkMovieInWatchList(@RequestParam Integer watchlistId, @RequestParam Integer movieId) {
        Boolean check = watchListService.checkMovieInWatchList(watchlistId, movieId);
        return ResponseEntity.ok(check);
    }
	
	@PutMapping("/add")
	public ResponseEntity<String> addMovieToWatchList(@RequestBody WatchListAddMovieRequest watchListAddMovieRequest){
		watchListService.addMovieToWatchList(
				watchListAddMovieRequest.getWatchlistId(),
				watchListAddMovieRequest.getMovieId()
				);
		
		return ResponseEntity.ok("Add movie to watch list success!");
	}
	
	@GetMapping("/user")
	public ResponseEntity<WatchListResponse> getWatchListByAuthenticatedUser(){
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findUserByEmail(email);
		
		return ResponseEntity.ok(watchListConvert.watchListConvertToWatchListResponse(user.getWatchList()));
	}
}
