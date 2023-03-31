package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.request.EmpAttendanceRequest;

@Repository
public interface EmpAttendanRequestRepository extends JpaRepository<EmpAttendanceRequest,Integer> {

	
}
