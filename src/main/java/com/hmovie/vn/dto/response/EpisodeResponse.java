package com.hmovie.vn.dto.response;


public class EpisodeResponse {
	
	private Integer id;
	
	private Integer totalEpisode;	
	
	private String slug;
	
	private Integer episodeNumber;

	private String episodeUrl;
	
	
	


	public EpisodeResponse(Integer id, Integer totalEpisode, String slug, Integer episodeNumber, String episodeUrl) {
		
		this.id = id;
		this.totalEpisode = totalEpisode;
		this.slug = slug;
		this.episodeNumber = episodeNumber;
		this.episodeUrl = episodeUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotalEpisode() {
		return totalEpisode;
	}

	public void setTotalEpisode(Integer totalEpisode) {
		this.totalEpisode = totalEpisode;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
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
