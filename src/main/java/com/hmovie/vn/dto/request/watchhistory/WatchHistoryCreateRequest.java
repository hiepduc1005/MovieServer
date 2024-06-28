package com.hmovie.vn.dto.request.watchhistory;



public class WatchHistoryCreateRequest {
	private Integer userId;
	
	private Integer movieId;
	
	private Integer episodeNumber;
	
	

	public Integer getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(Integer episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	
	
	
}
