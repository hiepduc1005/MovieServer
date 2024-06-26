package com.hmovie.vn.dto.response;

import java.math.BigDecimal;
import java.util.List;


public class MovieResponse {
    private Integer id;
    private String imdbId;
    private String title;
    private String description;
    private String releaseDate;
    private String postUrl;
    private String backDropUrl;
    private String slug;
    private Integer duration;
    private BigDecimal rating;
    private List<String> genres;
    private List<String> actors;
    private List<String> directors;
    private String trailerUrl;
    private List<EpisodeResponse> episodes;
    
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public MovieResponse(Integer id, String imdbId, String title, String description, String releaseDate,
			String postUrl, String backDropUrl, String slug, Integer duration, BigDecimal rating, List<String> genres,
			List<String> actors, List<String> directors, String trailerUrl,List<EpisodeResponse> episodes) {
		
		this.id = id;
		this.imdbId = imdbId;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.postUrl = postUrl;
		this.backDropUrl = backDropUrl;
		this.duration = duration;
		this.rating = rating;
		this.genres = genres;
		this.actors = actors;
		this.directors = directors;
		this.trailerUrl = trailerUrl;
		this.slug = slug;
		this.episodes= episodes;
	}
	
	
	public List<EpisodeResponse> getEpisodes() {
		return episodes;
	}
	public void setEpisodes(List<EpisodeResponse> episodes) {
		this.episodes = episodes;
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
	public String getPostUrl() {
		return postUrl;
	}
	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}
	public String getBackDropUrl() {
		return backDropUrl;
	}
	public void setBackDropUrl(String backDropUrl) {
		this.backDropUrl = backDropUrl;
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
	public List<String> getActors() {
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	public List<String> getDirectors() {
		return directors;
	}
	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}
	public String getTrailerUrl() {
		return trailerUrl;
	}
	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}
	
	
    
    
}
