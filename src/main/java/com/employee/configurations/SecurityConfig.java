package com.employee.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.employee.filter.jwtAuthFilter;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	private jwtAuthFilter authFilter;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println("this is password encoder");
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails normalUser=User.withUsername("nitish")
//				.password(passwordEncoder().encode("password"))
//				.roles("NORMAL")
//				.build();
//		
//		UserDetails adminUser=User.withUsername("nitish1")
//				.password(passwordEncoder().encode("password"))
//				.roles("ADMIN")
//				.build();
//		
//	  return new InMemoryUserDetailsManager(normalUser,adminUser);
//	 System.out.println(inMemoryUserDetailsManager);
//	 return inMemoryUserDetailsManager;
		System.out.println("this is user service file");
	return	new CustomUserDetailService();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		System.out.println("this is config file");
	return	httpSecurity.
		csrf().
		disable().
		authorizeHttpRequests().
		requestMatchers("/api/security/authenticate","/api/security/updatenew").
		permitAll().
		anyRequest().
		authenticated().
		and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider())
		.addFilterBefore(authFilter,UsernamePasswordAuthenticationFilter.class).build();
		
//		System.out.println(httpSecurity.build() );
//		return httpSecurity.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		System.out.println("this is doa authentication file");
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}


}
