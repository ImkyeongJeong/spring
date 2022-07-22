package com.company.mvc.emp;

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

@Controller
public class EmpController {
	//sl4jLoger인터페이스
	Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired EmpMapper mapper;
	
	//단건조회
	@RequestMapping("/emp")
	public String emp(EmpVO vo, Model model, HttpServletRequest request) {	
		// sysout대신에 log로 찍는다.
		logger.info(vo.toString());
		//model.addAttribute("emp", mapper.getEmp(vo)); // model을 이용해서 값을 전달해준다. $을 이용해서 값을 꺼내서 사용하면 된다. vo가 mapper로 넘어가서(실행 결과를 모델에 담아서 리턴해줌)
		request.setAttribute("emp", mapper.getEmp(vo));
		return "emp/emp";
	}

	//목록
	 @RequestMapping("/empList") 
	 public String empList(EmpReqVO vo, Model model) {
		 model.addAttribute("empList", mapper.getEmpList(vo));
		 return "emp/empList"; 
	 }
	 
	 //등록페이지 이동
	 @GetMapping ("/empInsert")
	 public String empInsert() {
		 return "emp/empInsert";
	 }
	 
	 //등록처리(post로 처리해뒀으니 굳이 URL따로 안 적어줘도 된다.)
	 //@PostMapping ("/empInsert")
	 @RequestMapping(value = "/empInsert", method = RequestMethod.POST) //옛날 방식
	 public String empInsertProc(EmpVO vo) {
		 logger.debug(vo.toString());
		 mapper.insert(vo);
		 System.out.println(vo.getEmployeeId()+"사번등록");
		 return "redirect:empList"; //Model을 갖고 가야된다.
	 }
	 
	 //수정페이지 이동
	 @RequestMapping("/empUpdate/{id}")
	 public String empUpdateForm(Model model, EmpVO vo,@PathVariable String id) {
		 vo.setEmployeeId(id);
		 //수정할 데이터가 보이기 위해 EmpVO로 관련 사원 단건 조회한다. (넘겨서 사용할 변수명, 값)
		 model.addAttribute("emp", mapper.getEmp(vo));
		 return "emp/empUpdate";
	 }
	 
	 //수정처리
	 @PostMapping("/empUpdate")
	 public String empUpdateProc(EmpVO vo) { 
		 mapper.update(vo);
		 return "redirect:empList";
	 }
	 
	 //삭제처리
	 @GetMapping("/empDelete")
	 public String empDeleteProc(EmpVO vo) {
		 mapper.delete(vo);
		 return "redirect:empList";
	 }
}
