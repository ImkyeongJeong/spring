package com.company.app.board.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String boardList(Model model, @ModelAttribute("cri") Criteria cri) { //모델에 담을 때 속성명 변경 가능(cri란 이름으로 담김)
		//페이징 처리
		//전체건수
		cri.setAmount(5);
		int total = service.getTotal(cri); //데이타 소스만큼 나옴
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		model.addAttribute("boardList", service.getList(cri));
		//모델에 저장하지 않더라도 커맨드 객체는 자동으로저장된다. 클래스이름의 첫 글자만 소문자로 해서 사용 가능
		model.addAttribute("criteria",cri);
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
	@GetMapping("/boardDelete")		//RedirectAttributes: 리다이렉트 할 때 request가 사라지니까 정보 담을 때 사용
	public String boardDeleteProc(Long bno, RedirectAttributes rttr) {
		if(service.delete(bno)) {
			rttr.addFlashAttribute("result1", "success"); //1회성으로 전달할 때 사용
			rttr.addAttribute("result2", "success");	  //parameter값 계속 저장되어 있음
		}
		
		return "redirect:boardList";
	}
}
