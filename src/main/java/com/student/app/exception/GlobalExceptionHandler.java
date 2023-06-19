package com.student.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerIdNotFoundException.class)
	//HttpServletRequest req----> It will says that at which end point the exception is occuring ,,for this ioc container will give the object to store in req reference
	public ResponseEntity<?> handleCustomerIdNotFoundException(CustomerIdNotFoundException exception , HttpServletRequest request)
	{
		ApiError apiError = new ApiError();
		apiError.setMessage(exception.getMessage());
		apiError.setLocalDateTime(LocalDateTime.now());
		apiError.setEndPoint(request.getRequestURI());
		apiError.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apiError,apiError.getHttpStatus());
		
	}
}
