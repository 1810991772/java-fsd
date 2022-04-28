package com.example.ExceptionHandling;

public class EmployeeDatabaseEmptyException extends RuntimeException {

	private String message;

	public EmployeeDatabaseEmptyException(String message) {
		super();
		this.message = message;
	}

	public EmployeeDatabaseEmptyException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}