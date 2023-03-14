package com.employee.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveManageRequest 
{
	private int casualLeave;
	private int sickLeave;
	private int marriageLeave;
	private int maternityLeave;
	private int paternityLeave;
	private int bareavementLeave;
    private int earnedLeave;
    private int employeeId;

}
