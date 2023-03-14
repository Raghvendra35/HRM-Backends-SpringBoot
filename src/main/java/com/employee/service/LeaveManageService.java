package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.dao.EmployeeRepository;
import com.employee.dao.LeaveManageRepository;
import com.employee.entities.Employee;
import com.employee.entities.LeaveManage;
import com.employee.request.LeaveManageRequest;

@Controller
public class LeaveManageService 
{

	@Autowired
	private LeaveManageRepository leaveManageRepo;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	//Save LeaveManage
	public LeaveManage saveLeaveManage(LeaveManageRequest leaveManageRequest)
	{
		
	 Employee employee=this.employeeRepository.findById(leaveManageRequest.getEmployeeId()).get();
    
	 LeaveManage leaveManage=new LeaveManage();
	 
	 leaveManage.setEmployee(employee);
	 leaveManage.setCasualLeave(leaveManageRequest.getCasualLeave());
	 leaveManage.setSickLeave(leaveManageRequest.getSickLeave());
	 leaveManage.setMarriageLeave(leaveManageRequest.getMarriageLeave());
	 leaveManage.setMaternityLeave(leaveManageRequest.getMaternityLeave());
	 leaveManage.setPaternityLeave(leaveManageRequest.getPaternityLeave());
	 leaveManage.setEarnedLeave(leaveManageRequest.getEarnedLeave());
	 
	 LeaveManage leaveM=this.leaveManageRepo.save(leaveManage);
	
	 return leaveM;
	}
	
	
	
	
	
	//Get All LeaveManage List
	public List<LeaveManage> allLeaveManageList()
	{
     List<LeaveManage> list=this.leaveManageRepo.findAll();
	 return list;	
	}
	
	
	
	//Get Single LeaveManage
	public LeaveManage getSingleLeaveManage(long leaveManageId)
	{
	  LeaveManage leave=this.leaveManageRepo.findById(leaveManageId).get();
		return leave;
	}
}














