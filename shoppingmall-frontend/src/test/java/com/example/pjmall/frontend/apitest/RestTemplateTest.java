package com.example.pjmall.frontend.apitest;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
	
	
	@Test
	public void test_getForObject() {
		RestTemplate restTemplate = new RestTemplate();

//		String result = restTemplate.getForObject("http://localhost:8088/shoppingmall/hello", String.class);
//		System.out.println( result );
	}
}
