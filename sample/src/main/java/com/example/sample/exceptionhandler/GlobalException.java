package com.example.sample.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.sample.Entities.User;

@RestControllerAdvice
public class GlobalException {
	
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
	        String errorMessage = "Name or password or email must not be blank also email should be valid";
	        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	    }
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e){
		return "user not found and check again the end points with valid http method";
	}
	
	

}
