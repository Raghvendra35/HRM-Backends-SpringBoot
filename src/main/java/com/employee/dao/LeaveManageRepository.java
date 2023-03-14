package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entities.LeaveManage;

public interface LeaveManageRepository extends JpaRepository<LeaveManage, Long> 
{

}
