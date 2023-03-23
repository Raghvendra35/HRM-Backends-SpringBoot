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
	public User savaAll(User user) {
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
	
	
}
