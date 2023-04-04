package com.employee.exception;

import java.util.LinkedHashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviser {

	private static final Logger logger=LoggerFactory.getLogger(ControllerAdviser.class);
	
	@ExceptionHandler(EmployeeRequestException.class)
	public ResponseEntity<Object> handlebadCredentionalsException(EmployeeRequestException ex,HttpServletRequest httprequest){
		
		Map<String,Object> body=new  LinkedHashMap<String,Object>();
		body.put("message", "array bhai pagal hha kya");
		
		logger.error("{}",httprequest.getRequestURI(),ex);
	return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
