package com.company.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	private Long bookNo;
	private String bookName;
	private String bookConverimg;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date   bookDate;
	private Long bookPrice;
	private String bookPublisher;
	private String bookInfo;

}
