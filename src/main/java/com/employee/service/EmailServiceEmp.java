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

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
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
		

		        String from="roms3546@gmail.com";
		        //Variable for gmail
				String host="smtp.gmail.com";
				
				//Get the System properties
				//System is a class
				
				Properties properties=new Properties();
				System.out.println("Properties "+properties);

				//Setting import information to properties Object
				
				//set the host
				              //key    and       value
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "876");// 465 is a port
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.auth", "true");
				
				//now we have set the information
				
				
				//step 1 to send email
				//To get the Session Object
				// we can not find the object of session directly
				//session has a factory method to provide the object of session
				     
				 
				
				//pass two things 1.properties object 2. Authenticate(Username and passowerd is correct)
			 Session session=Session.getInstance(properties, new Authenticator()
						{

							@Override
							protected PasswordAuthentication getPasswordAuthentication() {
								
								return new PasswordAuthentication("roms3546@gmail.com", "");
							}
					
						});
			 
			 
				// if the Username and password is correct then we will get session object
				
			         ((jakarta.mail.Session) session).setDebug(true);
			         
			
			         
			         
			         //step 2 Compose the message (text, attachment)
			         MimeMessage	m=new MimeMessage(session);
			    
			         
			         try
			         {
			        	//from email
			          m.setFrom(from);
			        	 
			          
			          
			          //adding recipient
			          m.addRecipient(Message.RecipientType.TO, new InternetAddress()); 
			        	 
			        
			        //adding subject to message
			        m.setSubject(subject);
			        
			        //adding text to  message 
//			        m.setText(message);
                      m.setContent("message","text/html");
                      
			        
			        
			        
			        
			        //step 3 send the message
			        Transport.send(m);
			        
			        System.out.println("Sent message ........................");
			        
			       
			        }catch(Exception e)
			         
			        {
			         e.printStackTrace();
			        }
			         
			
	

		return "Done";
	}
}

	
	
























