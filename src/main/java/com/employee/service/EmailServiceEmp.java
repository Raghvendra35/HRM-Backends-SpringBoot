package com.employee.service;

import java.io.File;
import java.util.Properties;

//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.employee.dao.EmailService;
import com.employee.entities.EmailDetails;
import com.employee.entities.Employee;



@Service
public class EmailServiceEmp implements EmailService
{
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;
	
	
	@Override
	public String sendSimpleMail(EmailDetails emailDetails) 
	{
		try
		{
			SimpleMailMessage mailMessage=new SimpleMailMessage();
			
			mailMessage.setFrom(sender);
			mailMessage.setTo(emailDetails.getRecipient());
			mailMessage.setText(emailDetails.getMsgBody());
			mailMessage.setSubject(emailDetails.getSubject());
			System.out.println("Inside Sevice method !!!");
			System.out.println(emailDetails.getSubject());
			//Send Mail
			System.out.println(mailMessage);
			javaMailSender.send(mailMessage);
			
			System.out.println("Inside Sevice method !!!");
			return "Email has been sent Successfully !!!";	
		}catch(Exception e)
		{
			return null;
		}
		
	}

	
	
	
	
	//Send Email with Attachment
	@Override
	public String sendMailWithAttachment(EmailDetails emailDetails) 
	{
//		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper;
//	   try	
//	   { 
//		  //Setting multipart as true for attachments  
//		  mimeMessageHelper=new MimeMessageHelper(mimeMessage, true); 
//		  
//		  mimeMessageHelper.setFrom(sender);
//		  mimeMessageHelper.setTo(emailDetails.getRecipient());
//		  mimeMessageHelper.setText(emailDetails.getMsgBody());
//		  mimeMessageHelper.setSubject(emailDetails.getSubject());
//		  
//		  //Adding the Attachment
//		  FileSystemResource file=new FileSystemResource(new File(emailDetails.getAttachment()));
//		  
//		  mimeMessageHelper.addAttachment(file.getFilename(), file);
//		  
//		  //Sending The Mail
//		  javaMailSender.send(mimeMessage);
//		  return "Mail has been sent Successfully !!!";
//		  
//	   }catch(Exception e)
//	   {
//		   e.printStackTrace();
//	   }
//   		
		return null;
	}

	
	
	
	//Send Mail
	public String mailSend(Employee emp)
	{
		System.out.println("+++++++++++++++++++++++========================");
    String email=emp.getEmailId();
    String profile=emp.getDesignation();
    
		return sender;
		
	}
	
	
	
	//Send Email for OTP
	public boolean sendEmailForOTP(String subject, String message,String to)
	{
	
            	//rest of code
		        boolean f=false;
		
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
				
			         ((javax.mail.Session) session).setDebug(true);
			         
			
			         
			         
			         //step 2 Compose the message (text, attachment)
			         MimeMessage	m=new MimeMessage(session);
			    
			         
			         try
			         {
			        	//from email
			          m.setFrom(from);
			        	 
			          
			          
			          //adding recipient
			          m.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); 
			        	 
			        
			        //adding subject to message
			        m.setSubject(subject);
			        
			        //adding text to  message 
			      //  m.setText(message);
                      m.setContent(message, "text/html");
                      
			        
			        
			        
			        
			        //step 3 send the message
			        Transport.send(m);
			        
			        System.out.println("Sent message ........................");
			        
			        f=true;
			        
			        }catch(Exception e)
			        {
			         e.printStackTrace();
			        }
			         
			       return f;
				
			}
	
	
}























