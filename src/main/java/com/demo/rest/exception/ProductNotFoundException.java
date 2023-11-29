package com.demo.rest.exception;

public class ProductNotFoundException extends RuntimeException {
	private String message;
	public ProductNotFoundException() {}
	public ProductNotFoundException(String message) {
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
		return "ProductNotFoundException [message=" + message + "]";
	}
	

}
