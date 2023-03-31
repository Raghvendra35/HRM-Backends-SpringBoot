package com.employee.request;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmpAttendanceRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int attendece;
	private String Ecode;
	private String name;
	private String departMent;
	private String shift;
	public int getAttendece() {
		return attendece;
	}
	public void setAttendece(int attendece) {
		this.attendece = attendece;
	}
	public String getEcode() {
		return Ecode;
	}
	public void setEcode(String ecode) {
		Ecode = ecode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartMent() {
		return departMent;
	}
	public void setDepartMent(String departMent) {
		this.departMent = departMent;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
	
}
