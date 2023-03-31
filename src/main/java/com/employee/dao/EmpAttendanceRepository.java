package com.employee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entities.EmpAttendance;

@Repository
public interface EmpAttendanceRepository extends JpaRepository<EmpAttendance, Integer>{
	
	public List<EmpAttendance> findEmpAttendanceByEcode(String ecode);
	
}
