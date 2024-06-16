package com.hmovie.vn.dto.request.Trailer;



public class TrailerCreateRequest {
    private String trailerUrl;

	public TrailerCreateRequest(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}
	
	

	public TrailerCreateRequest() {
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}
    
    
}
