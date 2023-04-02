package com.employee.service;

import java.io.File;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;



import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;



@Service
public class EmailServiceEmp 
{
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;
	
	
	//Send mail for Forgot Password (OTP)
	public String sendOTP(String receipent, String subject, String messageBody) throws MessagingException
	{
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage, true);
		
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setTo(receipent);
		mimeMessageHelper.setText(messageBody,true);
		mimeMessageHelper.setFrom(sender);
		
		javaMailSender.send(mimeMessage);
		
		return "Done";
	}
	
	
}























