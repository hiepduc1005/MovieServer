package com.hmovie.vn.dto.response;

import java.util.List;

public class WatchListResponse {
	private Integer id;
	private List<MovieWatchListResponse> movieResponses;
	
	
	public WatchListResponse(Integer id, List<MovieWatchListResponse> movieResponses) {
		this.id = id;
		this.movieResponses = movieResponses;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<MovieWatchListResponse> getMovieResponses() {
		return movieResponses;
	}
	public void setMovieResponses(List<MovieWatchListResponse> movieResponses) {
		this.movieResponses = movieResponses;
	}
	
	
}
