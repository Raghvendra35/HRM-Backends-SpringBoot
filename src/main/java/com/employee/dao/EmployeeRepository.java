package com.employee.dao;

import java.util.List;
import java.util.Map;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.entities.*;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>
{

    @Query(value= "SELECT employee_id as employeeId,first_name as firstName,email_id as emailId from employee",nativeQuery = true)
	public List<Map<String, Object>> findNameAndEmail();


//Search query
@Query("SELECT emp from employee as emp where CONCAT(emp.firstName,emp.emailId,emp.designation) LIKE %?1%")
public List<Employee> search(String keyword);


//@Query("SELECT emp from employee as emp where CONCAT(emp.firstName,emp.emailId,emp.designation) LIKE %?1%")
//public List<Employee> validation(String keyword);

//Login Page 
@Query(value="SELECT count(*) from employee where email_id=? and password=?", nativeQuery= true)
public int loginPage(String emailId, String password);
 
//
//@Query("Select e from Employee e where e.emailId = :email")
//public Employee getEmployeeByEmail(String email);

@Query(value="select emp from employee where emp.email_id=?",nativeQuery = true)
public String findEmployeeByEmail_id(String email_id);


}
