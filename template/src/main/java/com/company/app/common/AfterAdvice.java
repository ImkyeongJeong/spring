package com.company.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {

	//정상적으로 return될 때 log찍도록(다른 pointcut 참조 가능)
	@AfterReturning(pointcut =  "LogAdvice.allpointcut()", returning = "ret") //서비스 메서드 실행 후 리턴값 출력 
	public void afterLog(JoinPoint jp, Object ret) { //return값 받아오도록
		System.out.println("[after] 로그 출력");
		System.out.println(ret);
	}
}
