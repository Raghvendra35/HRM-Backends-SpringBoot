package com.employee.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dao.EmployeeRepository;
import com.employee.entities.EmailDetails;
import com.employee.entities.Employee;
import com.employee.entities.SendOTP;
import com.employee.service.EmailServiceEmp;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/")
public class EmailController
{

	@Autowired
	private EmailServiceEmp emailService;
	@Autowired
	private EmployeeRepository employeeRepo;
	
	
	@PostMapping("sendmail")
	public String sendMail(@RequestBody EmailDetails emailDetails)
	{
       String status=this.emailService.sendSimpleMail(emailDetails);
       System.out.println("Inside Controller method !!!");
		return status;
	}
	
	
	@PostMapping("mailwithattachment")
	public String SendMailWithAttachment(@RequestBody EmailDetails emailDetails)
	{
	  String status=this.emailService.sendMailWithAttachment(emailDetails);
      return status;	 	
	}
	
	
	
	//Forget Password Send mail (OTP) Code Here
	
	@PostMapping("forgot")
	public String sendOTP(@RequestBody SendOTP sendOTP, HttpSession session)
	{
		//Generate OTP Code of 6 digit
	 Random random=new Random(1000);
	 int otp=random.nextInt(999999);  
	 System.out.println("OTP ======= "+ otp);
	 
	 String subject="OTP from HRM";
	 String message=""
			        +"<div style='border: 1px solid #e2e2e2; padding"
			        +"<h3>"
			        +"OTP is"
			        +"<b>"+ otp
			        +"</h3> "
			        +"</div>";
	 String email=sendOTP.getEmail();
	 String to=email;
	 System.out.println("Email ===============");
	 System.out.println(email);
	 
	 
	 
	 boolean flag=this.emailService.sendEmailForOTP(subject, message, to);
	
	 if(flag)
	 {
		//Store OTP and email in local storage 
		session.setAttribute("emailOTP", otp); 
		session.setAttribute("email", email);
	 }
	 else
	 {
		 System.out.println("OTP and Email didn't save in local Storage !!!");
	 }
	 
	 return null;
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
        System.out.println(emailOTP);		
		String email=(String) session.getAttribute("email");
        System.out.println(email);
        
        
		if(emailOTP == otp)
		{
		  //then change the password
		 Employee employee=this.employeeRepo.getEmployeeByEmail(email);
		   if(employee ==null)
		     {		 
		 	 return "This User does not exits with this email !!!";
		     }
		     else{
			     //Changed Password
		    	 
			 
		         }
			 
		
		// return "Changed password !!!";
		}
		
		return "OTP didn't not match !!!";
	}
	
}

















