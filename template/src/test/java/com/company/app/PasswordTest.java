package com.company.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
	@Test
	public void test() {
		
		//암호화 객체 생성 (16: 암호화지연시간)
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		
		//패스워드 암호화
		String result = encoder.encode("1111");
		System.out.println(result);
		
		//암호된 것 비교할 때 equels 안됨 
		assertTrue(encoder.matches("1112", result));
		
	}
}
