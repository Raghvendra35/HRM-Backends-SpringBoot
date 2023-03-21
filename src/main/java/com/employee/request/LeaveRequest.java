package com.employee.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveRequest 
{
	    
	     private LocalDate fromDate;
	     private LocalDate toDate;
	     private String reasonToLeave;
	     private String typesOfLeave;
	     
		 private int employeeId;
		 
		 private int leaveDays;
		
		
		

}
