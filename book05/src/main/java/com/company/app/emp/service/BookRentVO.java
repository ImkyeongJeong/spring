package com.company.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookRentVO {
	private Long rentNo;
	private Long rentPrice;
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date rentDate;
	private char rentStatus;
}
