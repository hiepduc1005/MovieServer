package com.hmovie.vn.dto.request.Movie;

import java.math.BigDecimal;
import java.util.List;


public class MovieUpdateRequest {
    private String imdbId;

    private String title;
    private String description;
    private String releaseDate;

    private String postUrl;

    private String backDropUrl;

    private Integer duration;

    private BigDecimal rating;

    private Integer trailerId;

    private List<Integer> directorIds;

    private List<Integer> genresId;

    private List<Integer> actorsId;

	public MovieUpdateRequest(String imdbId, String title, String description, String releaseDate, String postUrl,
			String backDropUrl, Integer duration, BigDecimal rating, Integer trailerId, List<Integer> directorIds,
			List<Integer> genresId, List<Integer> actorsId) {
		
		this.imdbId = imdbId;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.postUrl = postUrl;
		this.backDropUrl = backDropUrl;
		this.duration = duration;
		this.rating = rating;
		this.trailerId = trailerId;
		this.directorIds = directorIds;
		this.genresId = genresId;
		this.actorsId = actorsId;
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

	public Integer getTrailerId() {
		return trailerId;
	}

	public void setTrailerId(Integer trailerId) {
		this.trailerId = trailerId;
	}

	public List<Integer> getDirectorIds() {
		return directorIds;
	}

	public void setDirectorIds(List<Integer> directorIds) {
		this.directorIds = directorIds;
	}

	public List<Integer> getGenresId() {
		return genresId;
	}

	public void setGenresId(List<Integer> genresId) {
		this.genresId = genresId;
	}

	public List<Integer> getActorsId() {
		return actorsId;
	}

	public void setActorsId(List<Integer> actorsId) {
		this.actorsId = actorsId;
	}
	
	
    
    
}
