package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entities.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	public User findByName(String name);

}