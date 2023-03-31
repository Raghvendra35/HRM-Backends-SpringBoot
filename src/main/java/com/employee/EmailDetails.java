package com.employee;

public class EmailDetails {

	private String receipent;
	private String messageBody;
	private String subject;
	private String attechment;
	public String getReceipent() {
		return receipent;
	}
	public void setReceipent(String receipent) {
		this.receipent = receipent;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttechment() {
		return attechment;
	}
	public void setAttechment(String attechment) {
		this.attechment = attechment;
	}
	public EmailDetails(String receipent, String messageBody, String subject, String attechment) {
		super();
		this.receipent = receipent;
		this.messageBody = messageBody;
		this.subject = subject;
		this.attechment = attechment;
	}
	
	public EmailDetails() {
		super();
		
	}

	
}

