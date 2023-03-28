package com.employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AccessTypes 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accessId;
	private String permission;
	private String models;
	private String roles;
	private String url;
	
}
