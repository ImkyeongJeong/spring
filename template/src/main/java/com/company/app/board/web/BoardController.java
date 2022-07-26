package com.company.app.board.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;
import com.company.app.common.Criteria;
import com.company.app.common.PageDTO;

@Controller
public class BoardController {
	//sl4jLogger인터페이스
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired BoardService service;
	
	//게시글 목록
	@RequestMapping("/boardList")
	public String boardList(Model model, Criteria cri) {
		//페이징 처리
		//전체건수
		cri.setAmount(5);
		int total = service.getTotal(cri); //데이타 소스만큼 나옴
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		model.addAttribute("boardList", service.getList(cri));
		return "board/boardList";
	}
	
	//상세보기
	@GetMapping("/board/{bno}")
	public String getBoard(BoardVO vo, Model model, @PathVariable Long bno) {
		vo.setBno(bno);
		model.addAttribute("board", service.getboard(vo));
		return "board/get";
	}
	
	//게시글 등록페이지 이동
	@GetMapping("/boardInsert")
	public String boardInsert() {
		return "board/boardInsert";
	}
	
	//게시글 등록처리
	@PostMapping("/boardInsert")
	public String boardInsertProc(BoardVO vo) {
		service.insert(vo);
		System.out.println(vo.getWriter()+"님의 게시글 등록완료");
		return "redirect:boardList";
	}
	
	//게시글 수정페이지 이동
	@RequestMapping("/boardUpdate/{bno}")
	public String boardUpdateForm(BoardVO vo, Model model, @PathVariable Long bno) {
		vo.setBno(bno);
		model.addAttribute("board", service.getboard(vo));
		return "board/boardUpdate";
	}
	
	//게시글 수정
	@PostMapping("/boardUpdate")
	public String boardUpdateProc(BoardVO vo) {
		service.update(vo);
		return "redirect:boardList";
	}
	
	//게시글 삭제
	@GetMapping("/boardDelete")
	public String boardDeleteProc(Long bno) {
		service.delete(bno);
		return "redirect:boardList";
	}
}
