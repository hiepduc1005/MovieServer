package com.hmovie.vn.dto.request.Genre;



public class GenreCreateRequest {
    private String name;

	public String getName() {
		return name;
	}
	
	

	public GenreCreateRequest() {
		
	}



	public void setName(String name) {
		this.name = name;
	}

	public GenreCreateRequest(String name) {
		
		this.name = name;
	}
    
    
}
