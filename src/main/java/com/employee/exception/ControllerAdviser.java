package com.employee.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviser extends ResponseEntityExceptionHandler {

	private static final Logger logger=LoggerFactory.getLogger(ControllerAdviser.class);
	
	@ExceptionHandler(EmployeeRequestException.class)
	public ResponseEntity<Object> handlebadCredentionalsException(EmployeeRequestException ex,WebRequest request, HttpServletRequest httprequest){
		System.out.println("testldfsdfdsf");
		Map<String, Object> body = new LinkedHashMap<String,Object>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
		
		logger.error("{}",httprequest.getRequestURI(),ex);
	return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleMainException(Exception ex,WebRequest request,HttpServletRequest httpRequest){
		 Map<String, Object> body = new LinkedHashMap<String,Object>();
	     body.put("timestamp", LocalDateTime.now());
	     body.put("message", "Server error, Please contact IT Team");
	        
	     logger.error("Error in calling {}",httpRequest.getRequestURI(),ex);
	     
	     return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
