package com.hmovie.vn.exception;



public class ActorException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ActorException(String message) {
		this.message = message;
	}
    
    
}
