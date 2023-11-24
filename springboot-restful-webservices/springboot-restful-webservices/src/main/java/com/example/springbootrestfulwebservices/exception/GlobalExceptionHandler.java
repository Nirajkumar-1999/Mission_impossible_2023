package com.example.springbootrestfulwebservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest ){
		
		ErrorDetails erroDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"User Not Found"
				);
		return new ResponseEntity<>(erroDetails,HttpStatus.NOT_FOUND);
	}

@ExceptionHandler(EmailAlreadyExist.class)
public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException(ResourceNotFoundException exception, WebRequest webRequest ){
		
		ErrorDetails erroDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"User Email Already Exist"
				);
		return new ResponseEntity<>(erroDetails,HttpStatus.BAD_REQUEST);
	}

}
