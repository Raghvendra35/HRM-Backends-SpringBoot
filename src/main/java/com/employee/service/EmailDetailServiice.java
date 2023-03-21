package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.employee.*;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailDetailServiice {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("$spring.mail.username")private String sender;

	public void sendEmail() {
		
	}
	public String sentEmail(String receipent,String messageBody,String subject) throws MessagingException {
		
		MimeMessage MimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper MimeMessageHelper=new MimeMessageHelper(MimeMessage,true); 
		MimeMessageHelper.setSubject(subject);
		MimeMessageHelper.setTo(receipent);
		MimeMessageHelper.setText(messageBody,true);
		MimeMessageHelper.setFrom(sender);
		
		
		
//		simpleMail.setSubject(mails.getSubject());
//		simpleMail.setTo(mails.getReceipent());
//		simpleMail.setText(mails.getMessageBody());
//		simpleMail.setFrom(sender);

		javaMailSender.send(MimeMessage);
		return "mail Send successfully";
	}
	public String  sendMailWithAttechMent(EmailDetails emailDetails) throws MessagingException {
		MimeMessage mimMessage =javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimMessage);
		mimeMessageHelper.setFrom(sender);
		mimeMessageHelper.setTo(emailDetails.getReceipent());
		mimeMessageHelper.setSubject(sender);
		mimeMessageHelper.setText(sender);
		FileSystemResource fileSystem=new FileSystemResource(emailDetails.getAttechment());
		mimeMessageHelper.addAttachment(fileSystem.getFilename(),fileSystem);
		javaMailSender.send(mimMessage);
		
		return  "mail Send successfully";
	}
}

