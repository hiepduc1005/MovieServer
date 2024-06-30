package com.hmovie.vn.service.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmovie.vn.dto.response.WatchHistoryResponse;
import com.hmovie.vn.entity.WatchHistory;

@Service
public class WatchHistoryConvert {
	
	@Autowired
	public MovieConvert movieConvert;
	
	public WatchHistoryResponse watchHistoryConvertToWatchHistoryResponse(WatchHistory watchHistory) {
		return new WatchHistoryResponse(
				watchHistory.getId(),
				movieConvert.movieConvertToMovieHistoryResponse(watchHistory.getMovie()),
				watchHistory.getEpisodeNumber()
				);
	}
}
