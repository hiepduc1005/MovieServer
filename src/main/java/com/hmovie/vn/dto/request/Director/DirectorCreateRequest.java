package com.hmovie.vn.dto.request.Director;



public class DirectorCreateRequest {

    private String name;

	public DirectorCreateRequest(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	
    
}
