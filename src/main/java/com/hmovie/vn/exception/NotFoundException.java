package com.hmovie.vn.exception;

public class NotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	public NotFoundException(String message) {
		
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
