package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entities.EmpAttendance;

public interface EmpAttendanceRepository extends JpaRepository<EmpAttendance, Integer>{

}
