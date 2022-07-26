package com.company.app.emp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.emp.mapper.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml") //context.xml로 끝나는 파일들 읽어들여 EmpMapper인터페이스 읽어들임
public class EmpMapperTest {
	@Autowired EmpMapper mapper;
	
	@Test
	public void test() {
	}
}
