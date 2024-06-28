package com.hmovie.vn.service;

import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.entity.WatchHistory;

public interface WatchHistoryService {
	
	WatchHistory createWatchHistory(WatchHistory watchHistory);
	WatchHistory update(WatchHistory watchHistory);
	void delete(Integer watchHistoryId);
	WatchHistory findByMovie(Movie movie);
}
