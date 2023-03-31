package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.entities.Employee;
import com.employee.entities.User;

public interface UserRepository  extends JpaRepository<User, Integer>
{
	public User findByName(String name);

	@Query(value="Select * from user where name=?",nativeQuery=true)
	public User findRole(String username);
	
	@Query(value="update user set password=? where email=?", nativeQuery=true)
	public User updatePassword(String email, String password);
	
	@Query(value="SELECT * FROM User WHERE email=?", nativeQuery= true)
	public User getUserByEmail(String email);

}
