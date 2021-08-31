package com.user.exception;

public class InvalidCredentialsException extends RuntimeException {
	
	private String message;
	
	public InvalidCredentialsException(String message) {
		super();
		this.message = message;
	}

	public InvalidCredentialsException() {
		super();
		
	}

	@Override
	public String toString() {
		return "Invalid login credentials or invalid auth token: "+message;
	}

}
