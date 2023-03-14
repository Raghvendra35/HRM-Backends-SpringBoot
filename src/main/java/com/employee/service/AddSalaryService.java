package com.employee.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.employee.dao.AddSalaryRepository;
import com.employee.dao.EmployeeRepository;
import com.employee.entities.AddSalary;
import com.employee.entities.Employee;
import com.employee.entities.LeaveEmployee;
import com.employee.request.SalaryRequest;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Controller
public class AddSalaryService
{
	@Autowired
	private AddSalaryRepository addSalaryRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	//Add salary
	public AddSalary saveSalary(SalaryRequest salaryRequest)
	{

	System.out.println("salaryRequest.............");
	System.out.println(salaryRequest);
	
	 Employee employee=employeeRepository.findById(salaryRequest.getEmployeeId()).get();	
	 
	 
	 AddSalary addSalary=new AddSalary();
	 
//	 addSalary.setEmployee(employee);
//	 addSalary.setEmployeeName(salaryRequest.getEmployeeName());
//	 addSalary.setMonths(salaryRequest.getMonths());
//	 addSalary.setAmount(salaryRequest.getAmount());
//  AddSalary salary=this.addSalaryRepository.save(addSalary);
	 
	double totalSalary=salaryRequest.getTotalSalary();
	System.out.println("totalSalary : "+totalSalary);
	
	
	double pf=salaryRequest.getPf();
	System.out.println("pf ==>"+pf);
	
	 pf=totalSalary*pf/100;
	 System.out.println(pf);
	 
	double esi=salaryRequest.getEsi();
	System.out.println("esi ==>"+esi);
	
	esi=totalSalary*esi/100;
	System.out.println(esi);
	
	
	double medicalInsurance=salaryRequest.getMedicalInsurance();
	System.out.println(medicalInsurance);

	int workingDays=salaryRequest.getWorkingDaysInMonths();
	System.out.println("Working Days==========================");
	System.out.println(workingDays);
	System.out.println("InHand Salary=====================");
	double salary=totalSalary-pf-esi-medicalInsurance;
	System.out.println(salary);

	 
	
		

	String january="january";
	String february="february";
	String march="march";
	String april="april";
	String may="may";
	String june="june";
	String july="july";
	String august="august";
	String september="september";
	String october="october";
	String november="november";
	String december="december";
	
	double perDaySalary;
	double inHandSalaryDeducted=0;
	double inHandSalary=0;
	String months=salaryRequest.getMonths();
	System.out.println(months);
	
	
	
	if(january.equalsIgnoreCase(months) || march.equalsIgnoreCase(months) || may.equalsIgnoreCase(months) || july.equalsIgnoreCase(months) 
			|| august.equalsIgnoreCase(months) || october.equalsIgnoreCase(months)	|| december.equalsIgnoreCase(months)         )
	{	
		//Working days total in months = 25
	
		
		System.out.println(months);
		perDaySalary=salary/25;
		System.out.println(perDaySalary);
		inHandSalary=perDaySalary*workingDays;
		
		inHandSalaryDeducted=salary-inHandSalary;
		
		System.out.println("Deducted Salary ===> "+inHandSalaryDeducted);
	    System.out.println("InHandSalary --->"+ inHandSalary);
	

	
	
	
	}
	else if(april.equalsIgnoreCase(months) || june.equalsIgnoreCase(months) || september.equalsIgnoreCase(months) || november.equalsIgnoreCase(months)   )
	{
		//Working days total in months = 24
		System.out.println(months);
		perDaySalary=salary/24;
		System.out.println(perDaySalary);
		
		inHandSalary=perDaySalary*workingDays;
		
		inHandSalaryDeducted=salary-inHandSalary;
		System.out.println(inHandSalary);
		System.out.println("Not Matched !!!");
	}
	
	
	else if(february.equalsIgnoreCase(months))
	{
		//Working days total in months = 22 /23
		System.out.println(months);
		perDaySalary=salary/22;
		System.out.println(perDaySalary);
		
		inHandSalary=perDaySalary*workingDays;
		
		inHandSalaryDeducted=salary-inHandSalary;
		
		System.out.println(inHandSalary);
		
		System.out.println("Not Matched !!!");
	}
	else
	{
		System.out.println("Not Matched !!!");
	}

	 
	 addSalary.setMonths(salaryRequest.getMonths());
	 addSalary.setEmployee(employee);
	 addSalary.setWorkingDaysInMonths(workingDays);
	 addSalary.setMedicalInsurance(medicalInsurance);
	 addSalary.setTotalSalary(totalSalary);
	 addSalary.setPf(pf);
	 addSalary.setEsi(esi);
	 addSalary.setInHandSalary(inHandSalary);
	 addSalary.setSalaryDeducted(inHandSalaryDeducted);
	 
	 AddSalary salaryObj=this.addSalaryRepository.save(addSalary);
	   return salaryObj;
	}
	
	
	
	
	
	
	
	//Get Salary By Id
	public Optional<AddSalary> getSalaryById(int salaryId)
	{
	   Optional<AddSalary> salary=this.addSalaryRepository.findById(salaryId);
		return salary;
	}
	
	
	
	
	//Update Salary
	public void updateSalary(AddSalary addSalary, int salaryId)
		{
			addSalary.setSalaryId(salaryId);
			addSalaryRepository.save(addSalary);
			
		}
		
		
	
	
	 //Delete The Salary
		public void deleteSalary(int salaryId)
		{
			addSalaryRepository.deleteById(salaryId);
			
		}
		
	
		
		//Show All Salary
		public List<AddSalary> getAllSalaryDetails()
		{
		 List<AddSalary> list=(List<AddSalary>) this.addSalaryRepository.findAll();
			return list;
		}
	
		
		// Pagination and Sorting 
		public Page<AddSalary> findAllSalaryWithPagination(Pageable page)
		{
			return addSalaryRepository.findAll(page);
			
		}
	
	
	
 		
	
	
		
//		//Generate Salary Slip PDF file
//		
//		private Logger logger=LoggerFactory.getLogger(AddSalaryService.class);
//	
//		public ByteArrayInputStream generateSalarySlipPdf(int salaryId)
//		{
//			
//	      AddSalary	salaryObj=this.addSalaryRepository.findById(salaryId).get();
//		
//	        double totalSalary=salaryObj.getTotalSalary();
//			
//			logger.info("Created Pdf Started");
//			String companyName="PSL";
//			String content="Salary_Slip-2023";
//			String emplName="Name";
//			String emplId="EmployeeId";
//			String contact="Contact No.";
//			String email="Email_Id";
//			
//			
//			
//			ByteArrayOutputStream out=new ByteArrayOutputStream();
//			
//			Document document=new Document();
//			
//			PdfWriter.getInstance(document, out);
//
//			document.open();
//			
//			Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
//			Paragraph titlePara=new Paragraph(companyName,titleFont);
//			titlePara.setAlignment(Element.ALIGN_CENTER);
//			document.add(titlePara);
//			
//			
//			
//			Font paraFont=FontFactory.getFont(FontFactory.HELVETICA, 18);
//			Paragraph paragraph=new Paragraph(content);
//			paragraph.setAlignment(Element.ALIGN_CENTER);
//			
//			document.add(paragraph);
//			//Border border=new SolidBorder(Color.GRAY,1f/2f);
//
//			int threecol=190;
//			int fullwidth[]= {threecol};
//			Table divider=new Table(2);
//			
//			//divider.setBorder(border);
//			divider.setBorder(threecol);
//			//document.add(border);
//			document.add(divider);
//			
//			
//			Paragraph paraEmpl=new Paragraph(emplName);
//			paraEmpl.setAlignment(Element.ALIGN_MIDDLE);
//			Paragraph paraEmplId=new Paragraph(emplId);
//			Paragraph paraEmplNo=new Paragraph(contact);
//			Paragraph paraEmail=new Paragraph(email);
//			
//			
//			
//			
//			document.add(paraEmpl);
//			document.add(paraEmplId);
//			document.add(paraEmplNo);
//			document.add(paraEmail);
//			   
//			  //Code V
//			  //Define Column
//			  //define column size
//		
//			  
//			  Table table=new Table(salaryId);
//			  
//			  table.addCell(companyName);
//			  //table.addCell(new Cell().add("Invoice").setBorder(Border.NO_BORDER));
//			  document.add(table);
//			  
//			   document.close();
//			
//			 return new ByteArrayInputStream(out.toByteArray());
//		}
//		
		
		
		
		      //Generate Salary Slip PDF file
		
				private Logger logger=LoggerFactory.getLogger(AddSalaryService.class);
			
				public ByteArrayInputStream generateSalarySlipPdf(int salaryId)
				{
					
			      AddSalary	salaryObj=this.addSalaryRepository.findById(salaryId).get();
			      System.out.println("Employee Id ++++++++++");
			      Employee emp=salaryObj.getEmployee();
			      
			      Employee employeeObj=employeeRepository.findById(emp.getEmployeeId()).get();
				
			      double totalSalary=salaryObj.getTotalSalary();
					
					logger.info("Created Pdf Started");
					String companyName="Pratikshat Solutions LLP";
					String address="A-79, Second Floor Okhla Phase II New Delhi";
					String salarySlip="Salary_Slip-2023";
					
					
					
					ByteArrayOutputStream out=new ByteArrayOutputStream();
					Document document=new Document();
					PdfWriter.getInstance(document, out);
         			document.open();
					
         		    Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
         		    fontTiltle.setSize(20);
         		    Paragraph paragraph1 = new Paragraph(companyName, fontTiltle);
         		    paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
         		    document.add(paragraph1);
         		     
         		    
         		    Font fontContent = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        		    fontContent.setSize(15);
         		    Paragraph paraSlip = new Paragraph(address, fontContent);
         		    paraSlip.setAlignment(Paragraph.ALIGN_CENTER);
         		    document.add(paraSlip);
         		   
         		    
         		   //Space
         		    Border border=new SolidBorder(Color.GRAY,1f/2f);
         		            int threecol=190;
         		   			int fullwidth[]= {threecol};
         		   			Table divider=new Table(2);
         		   			
         		   			//divider.setBorder(border);
         		   			divider.setBorder(threecol);
         		   			//document.add(border);
         		   			document.add(divider);
         		    
         		    Font fontSalary = FontFactory.getFont(FontFactory.TIMES_ROMAN);
         		    fontSalary.setSize(13);
        		    Paragraph paraSalary = new Paragraph(salarySlip, fontContent);
        		    paraSalary.setAlignment(Paragraph.ALIGN_CENTER);
        		    document.add(paraSalary);
    
         		    //Space
         		    Border border3=new SolidBorder(Color.GRAY,1f/2f);
         		            		   			int threecol3=190;
         		   			int fullwidth3[]= {threecol};
         		   			Table divider3=new Table(2);
         		   			
         		   			//divider.setBorder(border);
         		   			divider.setBorder(threecol);
         		   			//document.add(border);
         		   			document.add(divider);
         		   
         		   			
         		   			
         		    PdfPTable table = new PdfPTable(2);
         		  
         		    table.setWidthPercentage(100f);
         		    table.setWidths(new int[] {6,6});
         		    table.setSpacingBefore(8);

         		    // Create Table Cells for the table header  
         		    PdfPCell cell=new PdfPCell();
         		    
         		    table.addCell(String.valueOf("Name"));
        		    table.addCell(String.valueOf(employeeObj.getFirstName()));
        		    table.addCell(String.valueOf("Email_Id"));
       		        table.addCell(String.valueOf(employeeObj.getEmailId()));
       		        table.addCell(String.valueOf("Contact"));
     		        table.addCell(String.valueOf(employeeObj.getContact()));
     		        table.addCell(String.valueOf("Designation"));
    		        table.addCell(String.valueOf(employeeObj.getDesignation()));
    		        
    		        table.addCell(String.valueOf("Bank_Name"));
     		        table.addCell(String.valueOf(employeeObj.getBankName()));
     		        table.addCell(String.valueOf("Account_No."));
    		        table.addCell(String.valueOf(employeeObj.getAccountNumber()));
    		        document.add(table);
    		        
    		        
    		        //Space
         		         Border border2=new SolidBorder(Color.GRAY,1f/2f);
         		            		   			int threecol2=190;
         		   			int fullwidth2[]= {threecol};
         		   			Table divider2=new Table(3);
         		   			
         		   			//divider.setBorder(border);
         		   			divider.setBorder(threecol);
         		   			//document.add(border);
         		   			document.add(divider);
    		        
    		        PdfPTable table2 = new PdfPTable(4);
    		        table2.setWidthPercentage(100f);
         		    table2.setWidths(new int[] {3,3,3,3});
         		    table2.setSpacingBefore(5);
         		    PdfPCell cell2=new PdfPCell();
         		   
         		   table2.addCell(String.valueOf("Particular"));
      		       table2.addCell(String.valueOf(" "));
      		       table2.addCell(String.valueOf("Deductions"));
     		       table2.addCell(String.valueOf(""));
     		      
     		       table2.addCell(String.valueOf("Actual_Salary"));
     		       table2.addCell(String.valueOf(salaryObj.getTotalSalary()));
     		       table2.addCell(String.valueOf("Provident_Fund"));
    		       table2.addCell(String.valueOf(salaryObj.getPf()));
     		       
    		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("E.S.I"));
    		       table2.addCell(String.valueOf(salaryObj.getEsi()));
    		       
    		       table2.addCell(String.valueOf("DaysWorked"));
     		       table2.addCell(String.valueOf(salaryObj.getWorkingDaysInMonths()));
     		       table2.addCell(String.valueOf("Deducted_Salary"));
    		       table2.addCell(String.valueOf(salaryObj.getSalaryDeducted()));
    		       
    		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("Health_Insurance"));
    		       table2.addCell(String.valueOf(salaryObj.getMedicalInsurance()));
    		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("_"));
    		       table2.addCell(String.valueOf("_"));

    		      
    		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("Net_Salary"));
    		       table2.addCell(String.valueOf(salaryObj.getInHandSalary()));
    		       
    		           		       
    		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("_"));
     		       table2.addCell(String.valueOf("_"));
    		       table2.addCell(String.valueOf("_"));
    		       
  		           document.add(table2);
         		   
				   document.close();
					
					 return new ByteArrayInputStream(out.toByteArray());
				}
				

}








