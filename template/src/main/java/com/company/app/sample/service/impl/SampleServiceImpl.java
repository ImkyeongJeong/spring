package com.company.app.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.sample.mapper.Sample1Mapper;
import com.company.app.sample.mapper.Sample2Mapper;
import com.company.app.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired 
	Sample1Mapper s1;
	@Autowired 
	Sample2Mapper s2;
	
	@Override
	//@Transactional : 트랜잭션 둘다 되던지 하나라도 안되면 rollback처리 한다. /선언 위치 클래스(하위메서드), 인터페이스(하위클래스) 모두 설정됨 
	public void addData(String data) {
		s1.insert(data);
		s2.insert(data);
	}

}
