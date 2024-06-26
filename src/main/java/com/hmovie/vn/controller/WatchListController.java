package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.request.watchlist.WatchListAddMovieRequest;
import com.hmovie.vn.service.WatchListService;

@RestController
@RequestMapping("api/v1/watchlist")
public class WatchListController {
	
	@Autowired
	public WatchListService watchListService;
	
	@PutMapping("/add")
	public ResponseEntity<String> addMovieToWatchList(@RequestBody WatchListAddMovieRequest watchListAddMovieRequest){
		watchListService.addMovieToWatchList(
				watchListAddMovieRequest.getWatchlistId(),
				watchListAddMovieRequest.getMovieId()
				);
		
		return ResponseEntity.ok("Add movie to watch list success!");
	}
}
