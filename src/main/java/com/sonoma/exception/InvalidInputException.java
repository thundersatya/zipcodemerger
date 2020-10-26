package com.sonoma.exception;

@SuppressWarnings("serial")
public class InvalidInputException extends Exception {
	private String message;

	public InvalidInputException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
