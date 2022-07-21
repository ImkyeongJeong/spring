package com.company.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.mvc.emp.EmpMapper;
import com.company.mvc.emp.EmpVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/ajax")
	@ResponseBody //넘겨주는 vo객체를 json으로 변경
	public EmpVO ajax(EmpVO vo) {
		vo.setFirstName("hong");
		vo.setLastName("gildong");
		return vo;
	}
	
	@Autowired EmpMapper mapper;
	
	@RequestMapping("/emp")
	public String emp(EmpVO vo, Model model) {		  //알아서 vo에 담긴다.
		//sysout대신에 log로 찍는다.
		logger.info(vo.toString());
		model.addAttribute("emp", mapper.getEmp(vo)); //model을 이용해서 값을 전달해준다. $을 이용해서 값을 꺼내서 사용하면 된다. vo가 mapper로 넘어가서 실행 결과를 모델에 담아서 리턴해줌
		return "emp";
	}
	
	
	@RequestMapping("/empList")
	public String empList(Model model) {
		model.addAttribute("empList", mapper.getEmpList());
		return "empList";
	}
}
