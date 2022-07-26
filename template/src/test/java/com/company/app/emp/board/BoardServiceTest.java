package com.company.app.emp.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Setter(onMethod_=@Autowired)	// == @Autowired BoardService service;
	BoardService service;
	
	
	@Test
	public void insert() {
		for(int i=1; i<100; i++) {
		BoardVO vo = new BoardVO();
		vo.setTitle("test1");
		vo.setContent("test1 내용");
		vo.setWriter("user11");
		service.insert(vo);
		log.debug("생성된 게시물 번호: " + vo.getBno());
		}
	}
}
