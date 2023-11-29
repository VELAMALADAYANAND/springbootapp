package com.demo.rest.exception;

public class ReviewNotFoundException extends RuntimeException {
	String message;

	public ReviewNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ReviewNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ReviewNotFoundException [message=" + message + "]";
	}
	

}
