package com.employee.entities;

import java.time.LocalDateTime;
import java.util.Date;

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
	private String ecode;
	private String name;
	private String departMent;
	private String shift;
	private String in_time;
	private String out_time;
	private String uploadedOn;
	
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
	public String getIn() {
		return in_time;
	}
	public void setIn(String in_time) {
		this.in_time = in_time;
	}
	public String getOut() {
		return out_time;
	}
	public void setOut(String out_time) {
		this.out_time = out_time;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String richTextString) {
		ecode = richTextString;
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
	public String getUploadedOn() {
		return uploadedOn;
	}
	public void setUploadedOn(String uploadedOn) {
		this.uploadedOn = uploadedOn;
	}
	
	
}
