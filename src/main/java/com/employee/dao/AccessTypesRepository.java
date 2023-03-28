package com.employee.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.entities.AccessTypes;

public interface AccessTypesRepository extends JpaRepository<AccessTypes, Integer>
{
	@Query(value="Select * from access_types where roles=?",nativeQuery=true)
	public List<Map<String,Object>> getAllUrl(String role);
}
