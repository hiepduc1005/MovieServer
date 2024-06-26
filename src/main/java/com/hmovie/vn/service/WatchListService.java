package com.hmovie.vn.service;

import com.hmovie.vn.entity.WatchList;

public interface WatchListService {

	WatchList createWatchList();

	void addMovieToWatchList(Integer watchlistId,Integer movieId);
	
	boolean checkMovieInWatchList(Integer watchlistId,Integer movieId);
}
