package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.request.watchhistory.WatchHistoryCreateRequest;
import com.hmovie.vn.dto.response.WatchHistoryResponse;
import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.entity.User;
import com.hmovie.vn.entity.WatchHistory;
import com.hmovie.vn.service.MovieService;
import com.hmovie.vn.service.UserService;
import com.hmovie.vn.service.WatchHistoryService;
import com.hmovie.vn.service.convert.WatchHistoryConvert;

@RestController
@RequestMapping("api/v1/watch-history")
public class WatchHistoryController {
	
	@Autowired
	public WatchHistoryService watchHistoryService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public MovieService movieService;
	
	@Autowired
	public WatchHistoryConvert watchHistoryConvert;
		
	@PutMapping("/movie")
	public ResponseEntity<WatchHistoryResponse> addMovieToWatchHistory(@RequestBody WatchHistoryCreateRequest watchHistoryCreateRequest){
		User user = userService.findUserById(watchHistoryCreateRequest.getUserId());
		Movie movie = movieService.findById(watchHistoryCreateRequest.getMovieId());
		
		WatchHistory watchHistory = watchHistoryService.findByMovie(movie);
		
		if(watchHistory == null) {
			WatchHistory newWatchHistory = new WatchHistory();
			newWatchHistory.setEpisodeNumber(watchHistoryCreateRequest.getEpisodeNumber());
			newWatchHistory.setMovie(movie);
			newWatchHistory.setUser(user);
			
			newWatchHistory = watchHistoryService.createWatchHistory(newWatchHistory);
			
			return ResponseEntity.ok(watchHistoryConvert.watchHistoryConvertToWatchHistoryResponse(newWatchHistory));		
		}
		
		watchHistory.setEpisodeNumber(watchHistoryCreateRequest.getEpisodeNumber());
		watchHistory = watchHistoryService.update(watchHistory);
		
		return ResponseEntity.ok(watchHistoryConvert.watchHistoryConvertToWatchHistoryResponse(watchHistory));
	}
}
