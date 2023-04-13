package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.context.ApplicationContext;



@EnableScheduling
@SpringBootApplication
public class HrManagementsApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(HrManagementsApplication.class, args);
		
		System.out.print("Running 8.....");
		System.out.println(" Testing DHHHH");
	}

}




