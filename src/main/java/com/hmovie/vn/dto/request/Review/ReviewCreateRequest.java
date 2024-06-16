package com.hmovie.vn.dto.request.Review;



public class ReviewCreateRequest {
    private String comment;
    
    
	public ReviewCreateRequest(String comment) {
		
		this.comment = comment;
	}
	
    public ReviewCreateRequest() {
		
		
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
    
}
