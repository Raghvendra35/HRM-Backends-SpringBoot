package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.LeaveManage;
import com.employee.request.LeaveManageRequest;
import com.employee.service.LeaveManageService;

@RestController
@RequestMapping("api")
public class LeaveManageController 
{

	@Autowired
	private LeaveManageService leaveManageService;
	
	
	//Save LeaveManage
	@PostMapping("/addleavemanage")
	public ResponseEntity<LeaveManage> addLeaveManage(@RequestBody LeaveManageRequest leaveManageRequest)
	{
	  try
	  {
      LeaveManage leaveManage=this.leaveManageService.saveLeaveManage(leaveManageRequest);
      
      return ResponseEntity.of(Optional.of(leaveManage));
	  }catch(Exception e)
	  {
		  e.printStackTrace();
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	  }
     }
	
	
	
	
    //Get All LeaveManage List
	@GetMapping("/all")
	public ResponseEntity<List<LeaveManage>> getAllLeaveManage()
	{
	try
	{
	 List<LeaveManage> listL=this.leaveManageService.allLeaveManageList();
	 return ResponseEntity.of(Optional.of(listL));
	}catch(Exception e)
	{
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}
	
	
	//Get Leave Manage by Id
	@GetMapping("/leave/{leaveManageId}")
	public ResponseEntity<LeaveManage>   getSingleLeaveManage(@PathVariable ("leaveManageId") int leaveManageId)
	{
	  LeaveManage leave=this.leaveManageService.getSingleLeaveManage(leaveManageId);
	
	  return ResponseEntity.of(Optional.of(leave));
	}
	
}











