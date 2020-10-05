package com.clientcrud.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.clientcrud.services.exceptions.DatabaseException;
import com.clientcrud.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError();
		standardError.setTimeStamp(Instant.now());
		standardError.setError("Resource Not Found");
		standardError.setMessage(e.getMessage());
		standardError.setPath(request.getRequestURI());
		standardError.setStatus(httpStatus.value());
		return ResponseEntity.status(httpStatus).body(standardError);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest request){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError();
		standardError.setTimeStamp(Instant.now());
		standardError.setError(e.getMessage());
		standardError.setPath(request.getRequestURI());
		standardError.setStatus(httpStatus.value());
		return ResponseEntity.status(httpStatus).body(standardError);
	}
	
	
	
}
