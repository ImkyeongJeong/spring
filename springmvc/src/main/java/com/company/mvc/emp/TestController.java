package com.company.mvc.emp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	//view와 model을 같이 사용하는 방법
	@RequestMapping("/paramtest")
	public ModelAndView paramtest() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("parameter");
		mv.addObject("param1","test");
		return mv;
	}
	@RequestMapping("/parameter") //페이지명과 url이 같다면 굳이 return값 적지 않아도 된다. / 다르다면 return해줘야 함
	public void parameter() {
		
	}
	
	@RequestMapping("/req1")
	public void req1(HttpServletResponse response,
					@RequestParam(required = false, defaultValue="park") String id //값이 없으면 디폴트로 지정한 값이 나타남
					) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//스트링[] request.getParameterValues() request.getParam
	@GetMapping("/req2")
	public void req2(HttpServletResponse response,
					  @RequestParam List<String> ids) {
		try {
			PrintWriter out;
			out = response.getWriter();
			out.print(ids);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/req3")
	public void req3(HttpServletResponse response,
					  @RequestParam Map<String, Object> map) {
		try {
			PrintWriter out;
			out = response.getWriter();
			out.print(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/req4")
	public void req4(HttpServletResponse response,
					ReqVO vo) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.print(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/req5")
	public void req5(HttpServletResponse response,
					ListReqVO vo) {
		try {
			PrintWriter out;
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			out.print(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//첨부파일
	@PostMapping("/req6")
	public void req6(HttpServletResponse response,
					  ReqVO vo, MultipartFile[] pic) { //MultipartFile
		try {
			PrintWriter out;
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			
			//첨부파일 업로드
			for(MultipartFile temp : pic)
			if(temp != null && temp.getSize() > 0) {
				File file = new File("d:/upload", temp.getOriginalFilename()); //업로드한 파일명
				temp.transferTo(file);
				out.print(temp.getOriginalFilename()+"<br>");
				out.print(temp.getSize()+"<hr>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/req7/{id}/{age}")
	public void req7(HttpServletResponse response,
					@PathVariable String id, @PathVariable int age) {
		try {
			PrintWriter out;
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			out.print(id);
			out.print(age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
