package com.employee.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.service.EmpAttendanceService;

@RestController
public class AttendenceUploadController {

	@Autowired
	private EmpAttendanceService empAttendanceService;
	
	@PostMapping("/attendence/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException{
		
		if(empAttendanceService.checkExcelFormate(file)) {
			this.empAttendanceService.attendenceDetails(file.getInputStream());
			
			return ResponseEntity.ok(Map.of("message","file upload and data is saved in db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("upload excel file");
	}
}
