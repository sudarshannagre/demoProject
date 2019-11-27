package com.demo.demoProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentServiceExceptions {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e){
		return exception(HttpStatus.INTERNAL_SERVER_ERROR, new ErrorResponse("Internal Server Error", e.getMessage()));
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleRecordNotFound(RecordNotFoundException e){
		return exception(HttpStatus.NOT_FOUND, new ErrorResponse("Record Not Found", e.getMessage()));
	}
		
	private ResponseEntity<ErrorResponse> exception(HttpStatus status, ErrorResponse e){
		return new ResponseEntity<>(e,status);
	}
}
