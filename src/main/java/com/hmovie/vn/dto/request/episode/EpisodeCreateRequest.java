package com.hmovie.vn.dto.request.episode;



public class EpisodeCreateRequest {
    private String movieImdbId;
	
	private Integer totalEpisode;	

	private Integer episodeNumber;
	
	private String episodeUrl;

	public String getMovieImdbId() {
		return movieImdbId;
	}

	public void setMovieImdbId(String movieImdbId) {
		this.movieImdbId = movieImdbId;
	}

	public Integer getTotalEpisode() {
		return totalEpisode;
	}

	public void setTotalEpisode(Integer totalEpisode) {
		this.totalEpisode = totalEpisode;
	}

	public Integer getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(Integer episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public String getEpisodeUrl() {
		return episodeUrl;
	}

	public void setEpisodeUrl(String episodeUrl) {
		this.episodeUrl = episodeUrl;
	}

	
	
}
