package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.employee.dao.EmployeeRepository;
import com.employee.dao.LeaveManageRepository;
import com.employee.entities.Employee;
import com.employee.entities.LeaveManage;
import com.employee.request.LeaveManageRequest;

@Component
public class LeaveManageService 
{

	@Autowired
	private LeaveManageRepository leaveManageRepo;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	//Save LeaveManage
	public LeaveManage saveLeaveManage(LeaveManageRequest leaveManageRequest, int empId)
	{
		
	 Employee employee=this.employeeRepository.findById(empId).get();
    
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
	
	
	
	
	//Get Sinlge LeaveManage By passing EmployeeId
	public LeaveManage sinlgeLeaveManage(int emplId)
	{
	   LeaveManage leave=this.leaveManageRepo.getLeaveManageByEmplId(emplId);
		return leave;
	}
	
	
	//update Casual Leave
	public int updateCasual(int casualleave, int empId)
	{
	 int res=this.leaveManageRepo.updateCasualLeave(casualleave, empId);
	 System.out.println("Inside Service Casual Leave ++++++++++++++++++");
	 System.out.println(res);
	 return res;
		
	}

	
	//update Sick Leave
	public int updateSick(int sickleave, int empId)
	{
	 int res=this.leaveManageRepo.updateSickLeave(sickleave, empId);
	 return res;
	}
	
	
	//update Marriage Leave
	public int updateMarriage(int marriageleave, int empId)
	{
	 int res=this.leaveManageRepo.updateMarriageLeave(marriageleave, empId);
	 return res;
	}
	
	
	//update MaternityLeave
	public int updateMaternity(int maternityleave, int empId)
	{
	 int res=this.leaveManageRepo.updateMaternityLeave(maternityleave, empId);
	 return res;
	}
	
	
	//update PaternityLeave
	public int updatePaternity(int paternityleave, int empId)
	{
	 int res=this.leaveManageRepo.updatePaternityLeave(paternityleave, empId);
	 return res;
	}
	
	//update Earn Leave
	public int updateEarn(int earnleave, int empId)
	{
	 int res=this.leaveManageRepo.updateEarnedLeave(earnleave, empId);
	 return res;
	}
	
	
	//update Bereavement Leave
	public int updateBereavement(int bereavementleave, int empId)
	{
	 int res=this.leaveManageRepo.updateBareavementLeave(bereavementleave, empId);
	 return res;
	}
	
	
}














