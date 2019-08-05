package com.cafe24.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

//	@ResponseBody
	@GetMapping({"/", "/main"})
	public String main() {
		System.out.println("================== test ====================");
		return "main/index";
	}
	
}
 