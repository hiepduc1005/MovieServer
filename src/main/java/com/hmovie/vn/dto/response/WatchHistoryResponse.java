package com.hmovie.vn.dto.response;


public class WatchHistoryResponse {
	
	private Integer id;
	
	private MovieResponse movieResponse;
	
	private Integer episodeNumber;

	

	public WatchHistoryResponse(Integer id, MovieResponse movieResponse, Integer episodeNumber) {
		this.id = id;
		this.movieResponse = movieResponse;
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

	public MovieResponse getMovieResponse() {
		return movieResponse;
	}

	public void setMovieResponse(MovieResponse movieResponse) {
		this.movieResponse = movieResponse;
	}

	
	
}
