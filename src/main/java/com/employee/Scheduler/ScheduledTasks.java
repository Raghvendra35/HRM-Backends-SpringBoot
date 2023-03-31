package com.employee.Scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.employee.dao.EmpAttendanRequestRepository;
import com.employee.dao.EmpAttendanceRepository;
import com.employee.entities.EmpAttendance;
import com.employee.request.EmpAttendanceRequest;

@Component
public class ScheduledTasks {

	private static final org.slf4j.Logger log=LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private EmpAttendanRequestRepository requestRepo;
	
	@Autowired
	private EmpAttendanceRepository empAttendanceRepository;
	
	@Scheduled(fixedRate = 1000*60*60)
	public void reportCurrentTime() {
	EmpAttendance empAttendance=new EmpAttendance(); 
	empAttendance.setIn("Sunday");
	empAttendance.setOut("Sunday");
//	empAttendanceRepository.save(empAttendance);
	}
	
	}
	

