package com.company.app.emp.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.app.emp.service.BookRentVO;
import com.company.app.emp.service.BookService;
import com.company.app.emp.service.BookVO;

@Controller
public class BookController {

	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired BookService service;
	
	
	//도서 목록
	@RequestMapping("/bookList")
	public String bookList(Model model, BookVO vo) {
		model.addAttribute("list", service.getBookList(vo));
		return "book/bookList";
	}	
	
	//도서 등록페이지 이동
	@GetMapping("/bookInsert")
	public String bookInsert() {
		return "book/bookInsert";
	}
	
	//등록처리
	@RequestMapping(value = "/bookInsert", method = RequestMethod.POST )
	public String bookInsertProc(BookVO vo) {
		logger.debug(vo.toString());
		service.insert(vo);
		return "rediect:bookList";
	}
	

	//대여현황 목록
	@RequestMapping("/rentList")
	public String rentList(Model model, BookRentVO vo) {
		model.addAttribute("rentList", service.getRentList(vo));
		return "book/rentList";
	}	
	
}
