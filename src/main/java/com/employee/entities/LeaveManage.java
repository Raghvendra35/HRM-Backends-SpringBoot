package com.employee.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class LeaveManage 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long leaveManageId;
	private int casualLeave;
	private int sickLeave;
	private int marriageLeave;
	private int maternityLeave;
	private int paternityLeave;
	private int bareavementLeave;
    private int earnedLeave;
    
    @OneToOne(targetEntity = Employee.class)
    private Employee employee;
    
}
