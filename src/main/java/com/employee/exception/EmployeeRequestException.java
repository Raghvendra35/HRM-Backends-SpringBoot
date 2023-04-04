package com.employee.exception;

public class EmployeeRequestException extends Exception {

	String message;

	public EmployeeRequestException(String message) {
		super();
		this.message = message;
	}

	public EmployeeRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRequestException(Exception ex) {
		super(ex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.message;
	}

	

}
