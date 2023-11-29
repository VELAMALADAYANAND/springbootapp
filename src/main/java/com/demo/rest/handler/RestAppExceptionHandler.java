package com.demo.rest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.rest.exception.ProductNotFoundException;
import com.demo.rest.exception.ReviewNotFoundException;

@ControllerAdvice
public class RestAppExceptionHandler extends ResponseEntityExceptionHandler  {
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFoundExceptionHandler(ProductNotFoundException ex1) {
		System.out.println(ex1);
		return new ResponseEntity<String>("Product not found",HttpStatus.NO_CONTENT);
		
	}
	@ExceptionHandler(ReviewNotFoundException.class)
	public ResponseEntity<String> reviewNotFoundExceptionHandler(ReviewNotFoundException ex2) {
		System.out.println(ex2);
		return new ResponseEntity<String>("reviews not found",HttpStatus.NO_CONTENT);
		
	}
	
}
