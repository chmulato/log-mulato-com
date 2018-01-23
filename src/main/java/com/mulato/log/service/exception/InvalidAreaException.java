package com.mulato.log.service.exception;

public class InvalidAreaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidAreaException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidAreaException(String message) {
		super(message);
	}

}
