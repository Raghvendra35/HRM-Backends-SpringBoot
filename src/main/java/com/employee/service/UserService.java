package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.dao.UserRepository;
import com.employee.entities.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	public User savaAll(User user) 
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User save = this.userRepository.save(user);
		return save;
	}
	
	public Optional<User> getByid(int id) {
		return this.userRepository.findById(id);
	}
	
	public User saveById(int id,User user) {
		user.setId(id);
	return	this.userRepository.save(user);
	
	}
	
	public List<User> getAllData() {
		List<User> findAll = this.userRepository.findAll();
		return findAll;
	}

	public String roles(String username)
	{
	 User role=this.userRepository.findRole(username);
	 return role.getRole();
	}
	
	
	
	//Set New Password
	public String changePassword(String email, String password)
	{
		System.out.println("Inside user Service");
		System.out.println(email);
		
		this.passwordEncoder.encode(password);
		System.out.println(this.passwordEncoder.encode(password));
		String pass=this.passwordEncoder.encode(password);
		System.out.println(pass);
		
		User user=new User();
		user.setPassword(this.passwordEncoder.encode(password));
		//this.userRepository.updatePassword(email, pass);
		this.userRepository.save(user);
		return null;
	}
	
	
}
