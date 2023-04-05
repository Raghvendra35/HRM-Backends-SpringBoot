package com.employee.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.employee.entities.Employee;
import com.employee.exception.EmployeeRequestException;
import com.employee.request.EmployeeDropdownResponse;

import jakarta.persistence.PersistenceContexts;
import jakarta.persistence.Query;

import com.employee.dao.EmployeeRepository;


@Controller
public class EmployeeService 
{
    @Autowired
	private EmployeeRepository employeeRepository;
    
//    @PersistenceContext
//	private EntityManager em;
    
  @Autowired
  private jakarta.persistence.EntityManager em;
    
    // get All Employees
      public List<Employee> getAllEmployee()
	  {
	   
     List<Employee> list=(List<Employee>) this.employeeRepository.findAll();
	 return list;
	  }

        
    // Save Employee
    public Employee addNewEmployee(Employee empl) throws Exception
    
    {
//    	System.out.println("---------------------"+"------------------");
//    	
//    	Employee empvaliDation=(Employee) this.employeeRepository.findAll();
//    	
//    	System.out.println("from database-----------"+empvaliDation.getEmailId());
//    	
//    	
//    	System.out.println("from the user--------------"+empl.getEmailId());
//    	
//    	if(empvaliDation.getEmailId().equals(empl.getEmailId())) {
//    		
//    		throw new Exception("Email_id is already exits");
//    	}
    	
    	
//    	System.out.println("emilafdalflafklakflllll"+empl.getEmailId());
    	
    	if((empl.getEmailId()!=null) && (empl.getContact()!=null)) {
    		
    		Query employeeValiation= em.createQuery("select emp from employee emp",Employee.class);
        	
//        	employeeValiation.setParameter("email", empl.getEmailId());
        	
//        	employeeValiation.setParameter("contact", empl.getContact());
        	
        	List<Employee> emp1=(List<Employee>)employeeValiation.getResultList();
        	
        	 for(int i=0; i<emp1.size();i++) {
        		 
        		 
        		 if(emp1.get(i).getContact().equals(empl.getContact())) {
             		System.out.println("Contact number is already exits-------------------"+emp1.get(i).getContact());
           		  throw new Exception("Contact number is already exits");
           		
           	}
             	
             	if(emp1.get(i).getEmailId().equals(empl.getEmailId())) {
                 	System.out.println("Email_id is already exits-------------------"+emp1.get(i).getEmailId());
             		  throw new EmployeeRequestException("EmailId is already exits");
             		
             	}
        	 }
        	
        	}
    	else {
    		
    		throw new EmployeeRequestException("please fill all the required");
    	}
    	
    	return employeeRepository.save(empl);
    }
    
    
    // Save Employee and Return Id
    public int addEmployeeAndGetId(Employee empl)
    {		
        Employee emp=(Employee) this.employeeRepository.save(empl);
        int id=emp.getEmployeeId();
     
        return emp.getEmployeeId();
    	
    }
    

    
    
    //Update Employee
    public void updateEmployeeById(int id, Employee emp)
    {
    	emp.setEmployeeId(id);
    	employeeRepository.save(emp);
    }
    
    
    
    
    
    //Delete Employee
    public void deleteEmployeeById(int empId)
    {
    	employeeRepository.deleteById(empId);
    }
    
    
    public Page<Employee> findEmployeeByPagination(Pageable page)
    {
    	
    	return employeeRepository.findAll(page);
    }
    
    
    
    
    
    
    // Get Employee By Id
    public Optional<Employee> getEmployeeById(int employeeId)
    {
    	Optional<Employee> employee=null;
    	try
    	{
    		employee=this.employeeRepository.findById(employeeId);	
    		return employee;
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return employee;
    	}
    
    
    
    
    
    
    // Get Employee By Id
    public List<Map<String, Object>> getNameAndEmail()
    {
    	    return  this.employeeRepository.findNameAndEmail();
    }

   //Pagination and Sorting
    public Page<Employee> getEmployeeWithPage(Pageable page)
    {
    	return this.employeeRepository.findAll(page);
    }
    
    

  //Search
    public List<Employee> searchKeyword(String keyword)
    {
    	if(keyword!= null)
    	{
    		this.employeeRepository.search(keyword);
    	}
           return this.employeeRepository.search(keyword);    	
    }
    

    
    //login Checking
    public int login(String email, String password)
    {
      int id=this.employeeRepository.loginPage(email, password);
    	return id;
    }
}

















