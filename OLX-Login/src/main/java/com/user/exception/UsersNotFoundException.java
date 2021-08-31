package com.user.exception;

public class UsersNotFoundException extends RuntimeException {
	private String message;
	
	public UsersNotFoundException(String message) {
		super();
		this.message = message;
	}

	public UsersNotFoundException() {
		super();
		
	}

	@Override
	public String toString() {
		return "Invalid auth-token:"+message;
	}

}
