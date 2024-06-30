package com.hmovie.vn.dto.response;


public class WatchHistoryResponse {
	
	private Integer id;
	
	private MovieHistoryResponse movieHistoryResponse;
	
	private Integer episodeNumber;

	

	public WatchHistoryResponse(Integer id, MovieHistoryResponse movieResponse, Integer episodeNumber) {
		this.id = id;
		this.movieHistoryResponse = movieResponse;
		this.episodeNumber = episodeNumber;
	}

	public Integer getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(Integer episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MovieHistoryResponse getMovieHistoryResponse() {
		return movieHistoryResponse;
	}

	public void setMovieHistoryResponse(MovieHistoryResponse movieHistoryResponse) {
		this.movieHistoryResponse = movieHistoryResponse;
	}

	
	
}
