package com.example.ExceptionHandling;

public class EmployeeIdException extends RuntimeException{
private String message;

public EmployeeIdException(String message) {
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
