package com.user.exception;

public class UsernameNotFoundException extends RuntimeException {
	private String message;
	
	public UsernameNotFoundException(String message) {
		super();
		this.message = message;
	}

	public UsernameNotFoundException() {
		super();
		
	}

	@Override
	public String toString() {
		return "Invalid auth-token:"+message;
	}

}
