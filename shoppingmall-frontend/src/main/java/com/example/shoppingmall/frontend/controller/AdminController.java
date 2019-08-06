package com.example.shoppingmall.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shoppingmall.frontend.vo.PasswordQuestion;
import com.example.shoppingmall.frontend.vo.UserVo;

@Controller
@RequestMapping( "/admin"  )
public class AdminController {
	
	@GetMapping( "" )
	public String login() {
		return "admin/main";
	}
	
}
