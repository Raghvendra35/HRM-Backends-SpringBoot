package com.employee.configurations;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.employee.entities.User;

@Service
public class CustomUserDetail implements   UserDetails {
User user;
	
	private List<GrantedAuthority> authorities;
	
	public CustomUserDetail() {
//		this.user=user;
		
//		authorities=Arrays.stream(user.getRole().split()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
				
	}

	public CustomUserDetail(User user) {
		this.user=user;
		
//		authorities=Arrays.stream(user.getRole().split()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
				
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
//		System.out.println(authorities);
	SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(user.getRole());
	System.out.println(simpleGrantedAuthority);
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		System.out.println(user.getPassword());
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println(user.getName());
		// TODO Auto-generated method stub
		return user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
