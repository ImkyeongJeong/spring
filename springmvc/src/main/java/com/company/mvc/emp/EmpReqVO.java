package com.company.mvc.emp;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpReqVO {
	private String employeeId;
	private String[] dept;
	private String jobId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sdt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date edt;
}
