package com.company.app.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FilecheckTask {
	
	//@Scheduled(fixedRate = 5000) //5초마다 실행
	public void checkFile() {
		System.out.println("task run....");
	}
}
