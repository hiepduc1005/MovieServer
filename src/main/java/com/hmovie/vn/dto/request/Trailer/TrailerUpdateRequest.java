package com.hmovie.vn.dto.request.Trailer;



public class TrailerUpdateRequest {
    private Integer id;
    private String trailerUrl;
	public TrailerUpdateRequest(Integer id, String trailerUrl) {
		
		this.id = id;
		this.trailerUrl = trailerUrl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrailerUrl() {
		return trailerUrl;
	}
	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}
	
	
    
    

}
