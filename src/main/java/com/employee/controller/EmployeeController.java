package com.employee.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.employee.dao.EmailService;
import com.employee.dto.APIResponse;
import com.employee.entities.*;
import com.employee.request.EmployeeDropdownResponse;
import com.employee.request.Massege;
import com.employee.service.EmailDetailServiice;
import com.employee.service.EmailServiceEmp;
//import com.employee.entities.Address;
//import com.employee.entities.Qualification;
import com.employee.service.EmployeeService;
import com.employee.service.UserService;

@RestController
@RequestMapping("api/employee")
@CrossOrigin("*")
public class EmployeeController 
{
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmailDetailServiice emailService;
	
	@Autowired
	private UserService userService;
	
	String subject="welcome";
	
	//@Autowired
    //private Address address;
    //@Autowired
	//private Qualification qualification;
	
	Employee empl;
	

	
	
	
	
	
	
	
	//Get single Employee URL/handler
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable ("id") int id)
	{
	 Optional<Employee> employee=employeeService.getEmployeeById(id);
	  
	    if(employee==null)
	    {
	     return	ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	 
	    return ResponseEntity.of(Optional.of(employee));
		
    	}
	
	
	
	
	
	
	
	

	
	//Save employee
	@PostMapping("/save")
	public ResponseEntity<Massege> addEmployee(@RequestBody Employee employee)
	 {
		String message="";
		String employeeName=employee.getFirstName();
		String profile=employee.getDesignation();
		String department=employee.getDesignation();
//		String fileName=file.getOriginalFilename();
		String messageBody="Hello<span>,</span><b>"+employeeName+"</b><br>"+"<p>I hope this letter finds you all well! I have some great news<br>"
				+ "<p>It is my pleasure to announce that <b> "+employeeName+" </b> will be joining our team as a <b>"+profile+"</b> on <b>25 Dec</b><br>"
				+ "<p><b>"+employeeName+"</b> will work with <b> IT Department </b> to [brief description of duties, title, etc.]<br>"
				+ "<p>He has previously worked at work/industry experience overview or recent graduation, etc.]<br>"
				+ "<p>We’re so excited that <b>"+department+"</b> has joined our team.<br>"
				+ "<p>As you’re able, please take a moment to introduce yourself to <b>"+profile+"</b>, and join me in welcoming<br>"
				+ "<p>our newest team member!</p>"
				+ "<p>Login Credential:</p>"
				+ "<p>Website Url:<a href='adfafdasf'></a></p>";	
		try
	    	{
		     
			 empl=employeeService.addNewEmployee(employee);
			 emailService.sentEmail(employee.getEmailId(),messageBody, subject);
				message="Employee added successfully Please Check your mail";
			
			 User user=new User();
//			 Random random=new Random();
//			 Integer randomPassword=random.nextInt(8);
			 user.setName(employee.getFirstName());
			 user.setPassword(employee.getPassword());
			 user.setEmail(employee.getEmailId());
			 user.setPhone(employee.getContact());
			 user.setRole("ROLE_EMPLOYEE");
			 userService.savaAll(user);
			 
			 return ResponseEntity.status(HttpStatus.OK).body(new Massege(message));
		
		   }catch(Exception e)
		   {
		    e.printStackTrace();
	     	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		   }
	 }

	
  //Save employee and Get Id
	@PostMapping("/saveemployeeId")
	public ResponseEntity<Integer> getEmployeeId(@RequestBody Employee employee)
	 {
				
		try
	    	{
		      int employeeId=employeeService.addEmployeeAndGetId(employee);
		     System.out.print("+++++++++++++++++++++++++++++");
		    // System.out.println(employeeId);
	         
		    // getId(employeeId);
		     return ResponseEntity.of(Optional.of(employeeId));
		
		   }catch(Exception e)
		   {
		    e.printStackTrace();
	     	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		   }
	 }

	
//	public int getId(int id)
//	{
//		this.employeeId=id;
//		System.out.print("Inside getId() method ===============================================");
//		System.out.print(this.employeeId);
//		return this.employeeId;
//	}
//	
//	
	
	
	
	
	
	// Update Employee By Id
	@PutMapping("/{employeeId}")
	public ResponseEntity updateEmployee(@PathVariable ("employeeId") int employeeId, @RequestBody Employee empl)
	{
		try
		{
		this.employeeService.updateEmployeeById(employeeId, empl);
		
       return ResponseEntity.ok(null);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	
	
	
	//Delete Employee
	@DeleteMapping("/{employeeId}")
	   public ResponseEntity<Void> deleteBook(@PathVariable("employeeId") int empId)
	   {
		   try
		   {
		   this.employeeService.deleteEmployeeById(empId);
		
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		   }catch(Exception e)
		   {
			   e.printStackTrace();
			   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  
		   }
		   
	   }
	
	
	
	
	
	
	// Get All employee
	@GetMapping()
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
	  List<Employee> list=employeeService.getAllEmployee();
	  
	   if(list.size()<=0)
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
	   
     	   return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
	}
	
	
	
	
	
	//Get All pagination and sorting
	@GetMapping("/paginations")
	public APIResponse<Page<Employee>> getAllEmpoyeeWithPagination(Pageable page)
	{
	 Page<Employee> empl=employeeService.findEmployeeByPagination(page);
		return new APIResponse<>(empl.getSize(),empl);
	}
	
	
	
	
	
	
	
	@GetMapping("/dropdown")
	public List<Map<String, Object>> getEmployeeDropdown() 
	{
	       return employeeService.getNameAndEmail();
	}


	
	
	
	
	//Pagination and Sorting 
   @GetMapping("/pagination")
   public Page<Employee> findEmployeeWithPage(Pageable page)
   {
	   return this.employeeService.getEmployeeWithPage(page);
   }

   
   //Search keyword
   @GetMapping("/search/{keyword}")
   public List<Employee> searchData(@PathVariable ("keyword") String keyword)
   {
	List<Employee> list=this.employeeService.searchKeyword(keyword);
	return list;
	   
   }
   
   
   
   //lopgin 
   @PostMapping("login")
   public int  loginHere(@RequestBody Employee employee)
   {
	      String email=employee.getEmailId();
	      String password= employee.getPassword();
    	int status=this.employeeService.login(email, password);
	    return status; 
   }
}












