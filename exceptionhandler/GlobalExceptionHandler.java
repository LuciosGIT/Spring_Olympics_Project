package com.example.olympics.com.exceptionhandler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.olympics.com.exceptions.ObjectNotFoundException;
import com.example.olympics.com.exceptions.StandardError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request){
		StandardError error = new StandardError();
		error.setError(e.getMessage());
		error.setTimeStamp(Instant.now());
		error.setPath(request.getRequestURI());
		error.setStatus(HttpStatus.NOT_FOUND);
		return ResponseEntity.status(error.getStatus()).body(error);
		
	}
}
