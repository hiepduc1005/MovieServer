package com.hmovie.vn.dto.response;


public class MovieAndEpisodeResponse {
	
	private EpisodeResponse episode;
	
	private MovieResponse movie;

	public MovieAndEpisodeResponse(EpisodeResponse episode, MovieResponse movie) {
		
		this.episode = episode;
		this.movie = movie;
	}

	public EpisodeResponse getEpisode() {
		return episode;
	}

	public void setEpisode(EpisodeResponse episode) {
		this.episode = episode;
	}

	public MovieResponse getMovie() {
		return movie;
	}

	public void setMovie(MovieResponse movie) {
		this.movie = movie;
	}
	
	

}
