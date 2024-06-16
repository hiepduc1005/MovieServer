package com.hmovie.vn.dto.response;



public class ReviewResponse {
    private Integer id;
    private String comment;
    private String createAt;
	public ReviewResponse(Integer id, String comment, String createAt) {
		
		this.id = id;
		this.comment = comment;
		this.createAt = createAt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	
	
    
    
}
