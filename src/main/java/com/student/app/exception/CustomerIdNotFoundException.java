package com.student.app.exception;

public class CustomerIdNotFoundException extends RuntimeException {

	public CustomerIdNotFoundException(String message) {
		super(message);
	}

}
