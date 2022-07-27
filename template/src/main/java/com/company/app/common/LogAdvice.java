package com.company.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //Component도 상관없음
@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* com.company.app..*Impl.*(..))")
	public void allpointcut() {}
	
	@Before("allpointcut()")
	public void printLog(JoinPoint jp) {
		String name = jp.getSignature().getName();
		//null이 아니고 인수가 있다면
		String args = jp.getArgs() != null && jp.getArgs().length > 0 ? jp.getArgs()[0].toString() : ""; //메서드 인수 값을 배열로 받아옴
		System.out.printf("[before] 로그 출력 name= %s args= %s", name, args);
	}

}
