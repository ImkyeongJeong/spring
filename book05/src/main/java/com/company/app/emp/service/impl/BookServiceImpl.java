package com.company.app.emp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.emp.mapper.BookMapper;
import com.company.app.emp.service.BookRentVO;
import com.company.app.emp.service.BookService;
import com.company.app.emp.service.BookVO;

@Service
public class BookServiceImpl implements BookService{

	@Autowired BookMapper mapper;
	
	@Override
	public List<BookVO> getBookList(BookVO vo) {
		return mapper.getBookList(vo);
	}

	@Override
	public int insert(BookVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public List<BookVO> getRentList(BookRentVO vo) {
		return mapper.getRentList(vo);
	}

}
