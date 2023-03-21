package com.employee.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.employee.dao.EmpAttendanceRepository;
import com.employee.entities.EmpAttendance;

@Service
public class EmpAttendanceService {

	@Autowired
	private EmpAttendanceRepository  empAttendanceReo;
	
	EmpAttendance empAttendance=new EmpAttendance(); 	
	
	
public static boolean checkExcelFormate(MultipartFile file){
		
		String contentType=file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}
		else {
			return false; 
		}
	}
	
	public EmpAttendance attendenceDetails(InputStream stream) throws IOException{
		List<EmpAttendance> record=new ArrayList<>();
		XSSFWorkbook work=new XSSFWorkbook(stream);
		XSSFSheet sheet=work.getSheetAt(0);
		Iterator<Row> rows=sheet.iterator();
		int rowNumber=0;
		while (rows.hasNext()) {
			
			Row row=rows.next();
			if(rowNumber==0) {
				
				rowNumber++;
				continue;
			}
			
			Iterator<Cell> cells=row.iterator();
			int cellNumber=0;
			while (cells.hasNext()) {
				
				Cell cell=cells.next();
				
//				switch (cellNumber) {
//				case 0: 
//				
//					empAttendance.setEcode(cell.getStringCellValue());
//				break;
//					case 1:empAttendance.setName(cell.getStringCellValue());
//				break;
//					case 2:empAttendance.setDepartMent(cell.getStringCellValue());
//					
//				break;
//				
//				case 3:empAttendance.setShift(cell.getStringCellValue());
//				
//				break;
//				case 4:empAttendance.setIn(cell.getNumericCellValue());
//			
//				break;
//				case 5:empAttendance.setOut(cell.getNumericCellValue());
//				break;
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + cellNumber);
//				}
//				cellNumber++;
				
				
				
				empAttendance.setEcode(cell.getStringCellValue());
				
				empAttendance.setName(cell.getStringCellValue());
				
				empAttendance.setDepartMent(cell.getStringCellValue());
				
				empAttendance.setShift(cell.getStringCellValue());
				
				empAttendance.setIn(cell.getNumericCellValue());
				
				empAttendance.setOut(cell.getNumericCellValue());
			}
			
		}
		
		return empAttendanceReo.save(empAttendance);
	}
}