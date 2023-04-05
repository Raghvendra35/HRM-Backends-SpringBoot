package com.employee.exception;

public class EmployeeRequestException extends Exception {

	private static final long serialVersionUID = 7223835588340095223L;

	String message;

	public EmployeeRequestException(String message) {
		super(message);
		this.message = message;
	}

	public EmployeeRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRequestException(Exception ex) {
		super(ex);
		this.message=ex.getMessage();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.message;
	}

	

}
