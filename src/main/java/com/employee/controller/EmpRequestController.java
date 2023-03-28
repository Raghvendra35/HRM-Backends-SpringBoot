package com.employee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.dao.EmpAttendanRequestRepository;
import com.employee.entities.EmpAttendance;
import com.employee.request.EmpAttendanceRequest;

@RestController
public class EmpRequestController {

	@Autowired
	private EmpAttendanRequestRepository empAttendanRequestRepository;
	
	
	
	@PostMapping("/uploadEmpRecord")
	public List<EmpAttendanceRequest> empAttendanceRequest(@RequestParam("file") MultipartFile multipartfile) throws IOException{
		List<EmpAttendanceRequest> record=new ArrayList<>();
		XSSFWorkbook work=new XSSFWorkbook(multipartfile.getInputStream());
		XSSFSheet sheet=work.getSheetAt(0);
		Iterator<Row> rows=sheet.iterator();
		
		
		 for (int i=1; i<= sheet.getLastRowNum(); i++){
			 
			 EmpAttendanceRequest empAttendanceRequest=new EmpAttendanceRequest(); 
			 
			 empAttendanceRequest.setEcode(NumberToTextConverter.toText(sheet.getRow(i).getCell(0).getNumericCellValue()));
				 
			 empAttendanceRequest.setName(sheet.getRow(i).getCell(1).getStringCellValue());
				 
			 empAttendanceRequest.setDepartMent(sheet.getRow(i).getCell(2).getStringCellValue());
				 
			 empAttendanceRequest.setShift(sheet.getRow(i).getCell(3).getStringCellValue());
			 record.add(empAttendanceRequest);
		}
		 
		return  empAttendanRequestRepository.saveAll(record);
}
	
}
