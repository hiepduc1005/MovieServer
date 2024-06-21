package com.hmovie.vn.dto.response;

import java.math.BigDecimal;
import java.util.List;

public class MovieEpisodeResponse {
	private Integer id;
    private String imdbId;
    private String title;
    private String description;
    private String releaseDate;
    private Integer duration;
    private BigDecimal rating;
    private List<String> genres;
    private String trailerUrl;
    private Integer totalEpisode;
    private String episodeUrl;
    private String slug;
    
	public MovieEpisodeResponse(Integer id, String imdbId, String title, String description, String releaseDate,
			 Integer duration, BigDecimal rating, List<String> genres,
			String trailerUrl, Integer totalEpisode, String episodeUrl, String slug) {
		this.id = id;
		this.imdbId = imdbId;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		
		this.duration = duration;
		this.rating = rating;
		this.genres = genres;
		this.trailerUrl = trailerUrl;
		this.totalEpisode = totalEpisode;
		this.episodeUrl = episodeUrl;
		this.slug = slug;
	}
	
	

	public String getSlug() {
		return slug;
	}



	public void setSlug(String slug) {
		this.slug = slug;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public Integer getTotalEpisode() {
		return totalEpisode;
	}

	public void setTotalEpisode(Integer totalEpisode) {
		this.totalEpisode = totalEpisode;
	}

	public String getEpisodeUrl() {
		return episodeUrl;
	}

	public void setEpisodeUrl(String episodeUrl) {
		this.episodeUrl = episodeUrl;
	}
	
	
    
    
}
