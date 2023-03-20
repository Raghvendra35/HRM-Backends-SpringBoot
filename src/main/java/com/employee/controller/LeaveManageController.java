package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PostMapping("/addleavemanage/{empId}")
	public ResponseEntity<LeaveManage> addLeaveManage(@RequestBody LeaveManageRequest leaveManageRequest,@PathVariable int empId)
	{
	  try
	  {
      LeaveManage leaveManage=this.leaveManageService.saveLeaveManage(leaveManageRequest,empId);
      
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
	
	
	//Get LeftLeave by passing leaveManageId
	@GetMapping("/leave/{leaveManageId}")
	public ResponseEntity<LeaveManage>   getSingleLeaveManage(@PathVariable ("leaveManageId") int leaveManageId)
	{
	  LeaveManage leave=this.leaveManageService.getSingleLeaveManage(leaveManageId);
	
	  return ResponseEntity.of(Optional.of(leave));
	}
	
	
	
	
	//Get leftLeave by passing employeeId
	@GetMapping("/byemployeeId/{empId}")
	public ResponseEntity<LeaveManage> leaveM(@PathVariable ("empId") int empId)
	{
	  LeaveManage leaveM=this.leaveManageService.sinlgeLeaveManage(empId);
	  return ResponseEntity.of(Optional.of(leaveM));
	}
	
	
	
	
	
	//update Casual Leave
	@PutMapping("/updatecasualleave/{casualleave}/{empId}")
	public int causalLeave(@PathVariable int casualleave,@PathVariable int empId)
	{
	  int res=this.leaveManageService.updateCasual(casualleave, empId);
	 System.out.println("+++++++++++++Casula Leave+++++++++++++++");
   //	 System.out.println(res);
		return res;
	}
	
	
	//update Sick Leave
	@PutMapping("/updatesickleave/{sickLeave}/{empId}")
	public int sickLeave(@PathVariable int sickLeave, @PathVariable int empId)
	{
	  int res=this.leaveManageService.updateSick(sickLeave, empId);
		return res;
	}
	
	
	//update Marriage Leave
	@PutMapping("/updatemarriageleave/{marriageLeave}/{empId}")
	public int marriageLeave(@PathVariable int marriageLeave, @PathVariable int empId)
	{
		int res=this.leaveManageService.updateMarriage(marriageLeave, empId);
		return res;
	}
	
	
	//update MaternityLeave
	@PutMapping("/updatematernityleave/{maternityLeave}/{empId}")
	public int maternityLeave(@PathVariable int maternityLeave, @PathVariable int empId)
	{
		    int res=this.leaveManageService.updateMaternity(maternityLeave, empId);
			return res;
	}	
	
	
	//update PaternityLeave
	@PutMapping("/updatepaternityleave/{paternityLeave}/{empId}")
	public int paternityLeave(@PathVariable int paternityLeave, @PathVariable int empId)
	{
		   int res=this.leaveManageService.updatePaternity(paternityLeave, empId);
			return res;
	}	
		
	//update Earned Leave
	@PutMapping("/updateearnedleave/{earnLeave}/{empId}")
	public int earnLeave(@PathVariable int earnLeave, @PathVariable int empId)
	{
		int res=this.leaveManageService.updateEarn(earnLeave, empId);
			return res;
	}	

	
	//update BareavementLeave
	@PutMapping("/updatebareavementleave/{bareavementLeave}/{empId}")
	public int bareavementLeave(@PathVariable int bareavementLeave, @PathVariable int empId)
	{
		int res=this.leaveManageService.updateBereavement(bareavementLeave, empId);
			return res;
	}	
		
}











