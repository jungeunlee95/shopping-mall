package com.cafe24.shoppingmall.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    
    @RequestMapping("/hello")
	public String hello() { 
		return "hello/hello";
	}
}
 