package com.employee.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.weaver.ast.Instanceof;
import org.hibernate.type.NullType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.dao.EmpAttendanRequestRepository;
import com.employee.dao.EmpAttendanceRepository;
import com.employee.entities.EmpAttendance;
import com.employee.request.EmpAttendanceRequest;


@Service
public class EmpAttendanceService {

	@Autowired
	private EmpAttendanceRepository  empAttendanceReo;
	
	@Autowired
	private EmpAttendanRequestRepository empAttendanRequestRepository;
	
	EmpAttendance empAttendance=new EmpAttendance(); 	
	
	
	Calendar  calendar=Calendar.getInstance();
	
	 SimpleDateFormat formatTime = new SimpleDateFormat("HH:MM a");
	 
	 SimpleDateFormat uploadOnDate = new SimpleDateFormat("YYYY:MM:DD");
	 
	 SimpleDateFormat fullDate = new SimpleDateFormat();
	
public static boolean checkExcelFormate(MultipartFile file){
		
		String contentType=file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}
		else {
			return false; 
		}
	}
	
	public List<EmpAttendance> attendenceDetails(InputStream stream,Date uploadDateRequest) throws IOException, ParseException{
		
		List<EmpAttendance> record=new ArrayList<>();
		XSSFWorkbook work=new XSSFWorkbook(stream);
		XSSFSheet sheet=work.getSheetAt(0);
		Iterator<Row> rows=sheet.iterator();
	
		 
		 
		
		 for (int i=2; i < sheet.getLastRowNum(); i++){
			 
//			int cellNum= sheet.getRow(i).getLastCellNum();
			 
			 EmpAttendance empAttendance=new EmpAttendance(); 
			 
			 	empAttendance.setEcode(NumberToTextConverter.toText(sheet.getRow(i).getCell(0).getNumericCellValue()));
			 	
			 	CellType type=sheet.getRow(i).getCell(1).getCellType();
			 	
			 	if(type==CellType.NUMERIC) {
			 		
			 		empAttendance.setName(NumberToTextConverter.toText(sheet.getRow(i).getCell(1).getNumericCellValue()));
			 		
			 	}else {
			 		
			 		
			 		empAttendance.setName(sheet.getRow(i).getCell(1).getStringCellValue());
			 	}
			 	
//				 empAttendance.setName(sheet.getRow(i).getCell(1).getStringCellValue());
				 
				 empAttendance.setDepartMent(sheet.getRow(i).getCell(2).getStringCellValue());
				 
				 empAttendance.setShift(sheet.getRow(i).getCell(3).getStringCellValue());
				 
//				 System.out.println("---------------------boolean1"+sheet.getRow(i).getCell(4).getBooleanCellValue()+"cellNum");
				 
				 if(sheet.getRow(i).getCell(4).getStringCellValue().equals(" ")) {
					
					 	empAttendance.setIn("null");
				 }
				 else {
					 
					 String inTime =formatTime.format(sheet.getRow(i).getCell(4).getDateCellValue());
					 empAttendance.setIn(inTime);
				 }
				 
				 
				 empAttendance.setUploadedOn(uploadOnDate.format(uploadDateRequest));
				 
				 
					
					 int lastcell=sheet.getRow(1).getLastCellNum();
					 
					  for(int cn=0; cn<sheet.getRow(1).getLastCellNum(); cn++) {
						
						 
						  if(cn==lastcell-1) {
						
							  Cell cell = sheet.getRow(i).getCell(cn);
							  
//							 System.out.println("----------------------------boolean-----2"+sheet.getRow(i).getCell(cn).getDateCellValue());;
							  
							  if(sheet.getRow(i).getCell(cn).getDateCellValue()==null) {
								  
								  empAttendance.setOut(null);
								  
							  }else {
								  
								  Date date=cell.getDateCellValue();
							  
								 System.out.println("----------------------"+date.getDay());
								 
								  String outTime =formatTime.format(date.getTime());
								  
								  empAttendance.setOut(outTime);
							  }
							 		  
							  
							  
//							  if(date.getDay()==0) {
//								  
//								  empAttendance.setOut("Sunday");
//							  
//							  }
						}
						 
					  
					   
					  }
					
					
					record.add(empAttendance);
					
					}
				 
		return empAttendanceReo.saveAll(record);
	}
	
	public List<EmpAttendance> getAllAttendanceRecord(){
		
		return empAttendanceReo.findAll();
	}
	
	
	
	public List<EmpAttendance> getByEcode(String ecode) {
		
		return empAttendanceReo.findEmpAttendanceByEcode(ecode);
	}
	
	
}