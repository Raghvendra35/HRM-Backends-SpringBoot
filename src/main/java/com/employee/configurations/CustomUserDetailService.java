package com.employee.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.dao.UserRepository;
import com.employee.entities.User;

@Service
public class CustomUserDetailService  implements UserDetailsService{ 
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("this is customUserService");
		// TODO Auto-generated method stub
		User user = this.repository.findByName(username);
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getRole());
		
		if(user==null) {
			throw new UsernameNotFoundException("user not found !!");
			
		}else {
			CustomUserDetail customUserDetail= new CustomUserDetail(user); 
			System.out.println(customUserDetail);
		return customUserDetail;
	}
//	@Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	System.out.println("this is customUserService");
//	// TODO Auto-generated method stub
//	User user = this.repository.findByName(username);
//	System.out.println(user.getName());
//	System.out.println(user.getPassword());
//	System.out.println(user.getRole());
//	
//	if(user==null) {
//		throw new UsernameNotFoundException("user not found !!");
//		
//	}else {
//		CustomUserDetail customUserDetail= new CustomUserDetail(user); 
//		System.out.println(customUserDetail);
//		return customUserDetail;
//	}
	   
//    return   user.map(CustomUserDetail::new )
//       .orElseThrow(()->new UsernameNotFoundException("user not found"+username));
	


}

}
