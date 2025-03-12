package com.flourbox.com.flourbox.Exception;

import java.security.Timestamp;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public ProblemDetail handleGlobalException(Exception e) {
		ProblemDetail problemDetail=ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage() );
		problemDetail.setTitle("INTERNAL_SERVER_ERROR,PLEASE TRY AGAIN !");
		problemDetail.setProperty("timestamp", LocalDateTime.now());
		
		return problemDetail;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ProblemDetail handleUserNotFoundException(UserNotFoundException message) {
		ProblemDetail problemDetail=ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, message.getMessage() );
		problemDetail.setTitle("BAD_REQUEST");
		problemDetail.setProperty("timestamp", LocalDateTime.now());
		
		return problemDetail;
	}
	
}

