package com.company.app.emp.service;

import java.util.List;

import lombok.Data;

@Data
public class Departments {

	Integer departmentId;
	String departmentName;
	Integer managerId;
	Integer locationId;
	
	List<EmpVO> emp;
}
