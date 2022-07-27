package com.company.app.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.sample.service.SampleService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/*-context.xml")
@Log4j
public class SampleserviceTest {

	@Autowired SampleService service;
	
	@Test
	//@Transactional //없으면 1개만 들어감 / 있으면 둘 다 안 들어감
	public void test() {
		service.addData("안ㅇㅇㅇㅇㅇ농");
	}
}
