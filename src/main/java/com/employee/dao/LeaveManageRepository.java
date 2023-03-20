package com.employee.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.employee.entities.LeaveManage;

import jakarta.transaction.Transactional;

public interface LeaveManageRepository extends JpaRepository<LeaveManage, Long> 
{
  
	
	
   @Query(value="Select * from leave_manage where employee_employee_id=?",nativeQuery=true)
   public LeaveManage getLeaveManageByEmplId(int id);

 
    
   
   @Modifying
   @Query(value="UPDATE leave_manage SET casual_leave=? WHERE employee_employee_id=?", nativeQuery=true)
   @Transactional
   public int updateCasualLeave(int casualLeave, int emplId);
   
   
   @Modifying
   @Query(value="UPDATE leave_manage SET sick_leave=? WHERE employee_employee_id=?", nativeQuery=true)
   @Transactional
   public int updateSickLeave(int sickLeave, int emplId);
   
   
   @Modifying
   @Query(value="UPDATE leave_manage SET marriage_leave=? WHERE employee_employee_id=?", nativeQuery=true)
   @Transactional
   public int updateMarriageLeave(int marriageLeave, int emplId);

   
   @Modifying
   @Query(value="UPDATE leave_manage SET maternity_leave=? WHERE employee_employee_id=?", nativeQuery=true)
   @Transactional
   public int updateMaternityLeave(int maternityLeave, int emplId);
   
   
   @Modifying
   @Query(value="UPDATE leave_manage SET paternity_leave=? WHERE employee_employee_id=?", nativeQuery=true)
   @Transactional
   public int updatePaternityLeave(int paternityLeave, int emplId);
   
   
   @Modifying
   @Query(value="UPDATE leave_manage SET earned_leave=? WHERE employee_employee_id=?", nativeQuery=true)
   @Transactional
   public int updateEarnedLeave(int earnedLeave, int emplId);
   
   
   @Modifying
   @Query(value="UPDATE leave_manage SET bareavement_leave=? WHERE employee_employee_id=?", nativeQuery=true)
   @Transactional
   public int updateBareavementLeave(int bareavementLeave, int emplId);
   
   
   
   
}
