package com.company.mvc;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.mvc.emp.EmpMapper;
import com.company.mvc.emp.EmpVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class EmpMapperTest {
	@Autowired EmpMapper mapper;
	
	//@Test
	public void test() {
		EmpVO param = new EmpVO();
		param.setEmployeeId("100");
		Map<String,Object> result = mapper.getEmp(param);
		//Mapper에서 설정한 엘리어스 이름으로 키값을 넣어주면 벨류값 얻음		
		System.out.println(result.get("name"));
	}
	
	@Test
	public void list() {
		EmpVO param = new EmpVO();
		param.setDepartmentId("10");
		List<EmpVO> result = mapper.getEmpList(param);
		System.out.println(result);
	}
}
