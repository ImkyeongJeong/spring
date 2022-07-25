package com.company.mvc.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller + @ResponseBody와 같다.
@CrossOrigin(origins = "*") //CORS에러 방지(서버쪽에서 다른 도메인에서 들어와도 처리해주겠다. / 원칙적으론 Ajax는 같은 도메인요청만 받아줌)
public class TodoController {
	
	@Autowired TodoMapper mapper;
	
	@GetMapping(value ="/getText", produces = MediaType.TEXT_PLAIN_VALUE) //원하는 컨텐트Type적어주면 됨 ("text/plain; charset=utf-8"을 상수로 선언해뒀음 MediaType사용)
	public String getText() {
		return "안녕";
	}
	
	@GetMapping("/check")
	public List<TodoVO> check(TodoVO vo) {
		int a = 5/0;
		return mapper.findAll(vo);
	}
	
	//조회(자원이름 (테이블명)만 적어주면 된다.)
	@GetMapping(value = "/todo", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<TodoVO>> todoList(TodoVO vo) { //JSON구조의 String으로 넘김
		//int a = 5/0;
		List<TodoVO> list = mapper.findAll(vo);
		return new ResponseEntity<List<TodoVO>>(list, HttpStatus.OK); //response 상태값 넘길 수 있음 
	}
	
	//등록
	@PostMapping("/todo")
	public TodoVO todoInsert(TodoVO vo) {
		mapper.persist(vo);
		return vo;
	}
	
	//수정
	@PutMapping("/todo") //반드시 파라미터는 json구조의 String만! 가능
	public TodoVO todoUpdate(@RequestBody TodoVO vo) { //파싱해서 받아야 함
		mapper.merge(vo);
		return vo;
	}
	
	//삭제
	@DeleteMapping("/todo/{no}")
	public Integer todoDelete(@PathVariable Integer no) {
		mapper.remove(no);
		return no;
	}
	
	//단건조회
	@GetMapping("/todo/{no}")
	public TodoVO todoSelect (@PathVariable Integer no) {
		return mapper.findById(no);
	}
}
