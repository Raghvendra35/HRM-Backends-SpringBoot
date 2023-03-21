package com.employee.entities;

import org.apache.poi.ss.usermodel.RichTextString;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmpAttendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int attendece;
	private String Ecode;
	private String name;
	private String departMent;
	private String shift;
	private double in_time;
	private double out_time;
	
	public int getAttendece() {
		return attendece;
	}
	public void setAttendece(int attendece) {
		this.attendece = attendece;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getIn() {
		return in_time;
	}
	public void setIn(double in_time) {
		this.in_time = in_time;
	}
	public double getOut() {
		return out_time;
	}
	public void setOut(double out_time) {
		this.out_time = out_time;
	}
	public String getEcode() {
		return Ecode;
	}
	public void setEcode(String richTextString) {
		Ecode = richTextString;
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
