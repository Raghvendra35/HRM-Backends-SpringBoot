package com.employee.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dao.AccessTypesRepository;
import com.employee.dto.Login;
import com.employee.dto.TokenResponse;
import com.employee.entities.AccessTypes;
import com.employee.entities.User;
import com.employee.service.JwtService;
import com.employee.service.UserService;

@RestController
@RequestMapping("/api/security")
public class LoginController 
{
	@Autowired
	private UserService userService;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AccessTypesRepository accessTypesRepo;
	
	
	
	@GetMapping("/normal")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<String> normalUser() {
		return new ResponseEntity<String>("Hii this api for normal users",HttpStatus.OK);
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> adminUser(){
		System.out.println("admit controller");
		return new ResponseEntity<String>("Hii this api for admin",HttpStatus.OK);
	}
	
	@GetMapping("/admin/getAllData")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<User>> getAllData(){
		List<User> allData = this.userService.getAllData();
		return new ResponseEntity<List<User>>(allData,HttpStatus.OK);
	}
	
	@GetMapping("/getValue")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> getvalue(){
		System.out.println("admit controller");
		return new ResponseEntity<String>("Hii this api for admin for value get",HttpStatus.OK);
	}
	
//	@GetMapping("/new")
//	public ResponseEntity<String> user(){
////		User savaAll = this.userService.savaAll(user);
//		return new ResponseEntity<String>("i am nitish kumar",HttpStatus.OK);
//	}
	
	@PostMapping("/updatenew")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		System.out.println("THIS IS USER POST DATA IN DATABASE");
		User savaAll = this.userService.savaAll(user);
	   savaAll.setRole("ROLE_ADMIN");
	   int id=savaAll.getId();
	   User saveById = this.userService.saveById(id, user);
	   
		return new ResponseEntity<User>(saveById,HttpStatus.OK);
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
//		User savaAll = this.userService.savaAll(user);
		return new ResponseEntity<String>("hii this is not secure",HttpStatus.OK);
	}
	
	
	
	//Login here
	@PostMapping("/authenticate")
	public ResponseEntity<TokenResponse> generateToken(@RequestBody Login login) {
		System.out.println("generate token");
		
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
			if(authenticate.isAuthenticated())
			{
				
				 String generateToken = jwtService.generateToken(login.getUsername());
				 String username=login.getUsername();
				 String role=this.userService.roles(username);	
				
				 List<Map<String,Object>> navs=this.accessTypesRepo.getAllUrl(role);
						 
				 return new ResponseEntity<TokenResponse>((new TokenResponse("login Successfully",generateToken, role,navs)),HttpStatus.OK);
			
			}else 
			   {
				 throw new UsernameNotFoundException("invalid user request !!!");
			   }
		   
	         }
	
	
	//Create Role of Employee
//	@PostMapping("/updatenew")
//	public ResponseEntity<User> addData(@RequestBody User user){
//		System.out.println("THIS IS USER POST DATA IN DATABASE");
//		User savaAll = this.userService.savaAll(user);
//
//	   int id=savaAll.getId();
//	   User saveById = this.userService.saveById(id, user);
//	   
//		return new ResponseEntity<User>(saveById,HttpStatus.OK);
//	}
	
//	@PostMapping("/register")
//	public User registerUSer(@RequestBody User user){
//		System.out.println("Registered USer"+user);
//		
//		return null;
//	}
	
	


}
