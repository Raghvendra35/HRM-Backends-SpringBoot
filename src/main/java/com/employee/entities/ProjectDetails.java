package com.employee.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
public class ProjectDetails 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	private String projectName;
	private String clientName;
	private String teamLeader;
	private String developingTechnology;
	private String databaseTechnology;
	private LocalDate fromDate, toDate;
	public String projectManager;
	
	
	@OneToOne(targetEntity = Employee.class)
	private Employee employee;


	

	
	

}
