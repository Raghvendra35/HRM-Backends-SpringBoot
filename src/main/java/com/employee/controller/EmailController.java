package com.employee.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dao.UserRepository;
import com.employee.entities.EmailDetails;
import com.employee.entities.SendOTP;
import com.employee.service.EmailServiceEmp;
import com.employee.service.UserService;
import com.employee.entities.User;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/")
public class EmailController
{

	@Autowired
	private EmailServiceEmp emailService;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("sendmail")
	public String sendMail(@RequestBody EmailDetails emailDetails)
	{
     //  String status=this.emailService.sendSimpleMail(emailDetails);
       System.out.println("Inside Controller method !!!");
		return null;
	}
	
	
	@PostMapping("mailwithattachment")
	public String SendMailWithAttachment(@RequestBody EmailDetails emailDetails)
	{
	  //String status=this.emailService.sendMailWithAttachment(emailDetails);
      return null;	 	
	}
	
	
	
	
	//Forget Password Send mail (OTP) Code Here
		@PostMapping("forgot")
		public String sendOTP(@RequestBody SendOTP sendOTP, HttpSession session) throws MessagingException
		{
		
		//Generate OTP Code of 6 digit
		 Random random=new Random(10000);
		 int otp=random.nextInt(999999);  
		 System.out.println("OTP ======= "+ otp);
		 System.out.println(sendOTP.getEmail()); 
		 
		 String subject="OTP from HRM";
		 String message="OTP is"+otp;
//				        +"<div style='border: 1px solid #e2e2e2; padding"
//				        +"<h3>"
//				        +"OTP is"
//				        +"<b>"+ otp
//				        +"</h3> "
//				        +"</div>";
		
		 String email=sendOTP.getEmail();
		 String to=email;
		 System.out.println("Email ===============");
		 System.out.println(email);
		 
		 session.setAttribute("emailOTP", otp); 
		 session.setAttribute("email", email);
		 System.out.println("Print data from session");
		 System.out.println(session.getAttribute("emailOTP"));
		 System.out.println(session.getAttribute("email"));
		 
		 
		 //boolean flag=this.emailService.sendEmailForOTP(subject, message, to);
		this.emailService.sendOTP(to, subject, message);
		
		 if(true)
		 {
			//Store OTP and email in local storage 
			session.setAttribute("emailOTP", otp); 
			session.setAttribute("email", email);
		 }
		 else
		 {
			 System.out.println("OTP and Email didn't save in local Storage !!!");
		 }
		 
		 return "OTP has been sent on email successfully";
		}
	
	
	
	
		//here we will compare OTP -> localStorage OTP(Email OTP) and user will send OTP
		//If OTP verified then user can change password 
		//verify OTP 
		@PostMapping("/verify-otp")
		public String verifyOTP(@RequestBody  SendOTP sendOTP, HttpSession session)
		{
			int otp=sendOTP.getOtp();
			System.out.println("OTP +++++++++++++++");
			System.out.println(otp);
			
			int emailOTP=(int)session.getAttribute("emailOTP");
			System.out.println("emailOTP"+ emailOTP);
	        System.out.println(emailOTP);		
			String email=(String) session.getAttribute("email");
	        System.out.println(email);
	        
	        
			if(emailOTP == otp)
			{

	           System.out.println("OTP Verified !!!");
	    
			   //then change the password
			   User user=this.userRepo.getUserByEmail(email);
			      if(user ==null)
			         {		 
			 	      return "This User does not exist with this email !!!";
			         }
			         else
			         {
				      return "User is Present in database !!!";
				      
			         }
				 
			
		      }else
			    {
				return "OTP didn't not match !!!";	
			    }
		 
		    }
				 
		
			
	
	
	
	
	
	//Set New Password
	@PutMapping("changepassword")
	public String setNewPassword(@RequestBody User user, HttpSession session)
	{
		System.out.println(user.getPassword());
		System.out.println(session.getAttribute("email"));
		String pass=user.getPassword();
		String email=(String) session.getAttribute("email");
		
		this.userService.changePassword(email, pass);
		
		return "Password has been updated Successfully !!!";
	}
	
	
}

















