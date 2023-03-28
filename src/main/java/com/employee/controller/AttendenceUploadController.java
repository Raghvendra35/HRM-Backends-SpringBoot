package com.employee.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.entities.EmpAttendance;
import com.employee.service.EmpAttendanceService;

@RestController
public class AttendenceUploadController {

	@Autowired
	private EmpAttendanceService empAttendanceService;
	
	@PostMapping("/attendence/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,@RequestParam("date") Date uploadDateRequest) throws IOException, ParseException{
		
		if(empAttendanceService.checkExcelFormate(file)) {
			this.empAttendanceService.attendenceDetails(file.getInputStream(),uploadDateRequest);
			
			return ResponseEntity.ok(Map.of("message","file upload and data is saved in db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("upload excel file");
	}
	
	@GetMapping("/getByEcode/{id}")
	public List<EmpAttendance> getByEcode(@PathVariable("id") String id) {
		
		return empAttendanceService.getByEcode(id);
	}
	
	@GetMapping("/getAllAttendence")
	public List<EmpAttendance> getAllAttendance(){
		
		return empAttendanceService.getAllAttendanceRecord();
	}
}
