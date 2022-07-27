package com.company.app.emp.service;

import java.util.List;
import com.company.app.emp.service.BookRentVO;
import com.company.app.emp.service.BookVO;

public interface BookService {
	public int insert(BookVO vo);
	public List<BookVO> getBookList(BookVO vo);
	public List<BookVO> getRentList(BookRentVO vo);
}
