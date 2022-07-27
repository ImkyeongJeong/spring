package com.company.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aroundadvice {
	@Around("LogAdvice.allpointcut()")
	public Object printLog(ProceedingJoinPoint pjp) {
		Object ret = null;
		try {
			//서비스 실행전(현재시간 체크)
			long start = System.currentTimeMillis();
			//실제 실행해야 될 서비스 호출
			ret = pjp.proceed();			
			//서비스 실행 후 
			long end = System.currentTimeMillis();
			System.out.println("경과시간 : " + (end-start));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return ret;
	}
}
