package com.employee.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRequest 
{


	private String projectName;
	private String clientName;
	private String teamLeader;
	private String developingTechnology;
	private String databaseTechnology;
	private LocalDate fromDate, toDate;
	private int  employeeId;
	private String projectManager;
	
	
	
	
	
	
	
}
