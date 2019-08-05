package com.example.shoppingmall.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shoppingmall.frontend.vo.PasswordQuestion;
import com.example.shoppingmall.frontend.vo.UserVo;

@Controller
@RequestMapping( "/user"  )
public class UserController {
	
	@GetMapping( "/login" )
	public String login() {
		return "user/login";
	}
	
	@GetMapping( "/join" )
	public String join() {
		return "user/join";
	}
	
	@PostMapping( "/join" )
	public String join(UserVo userVo) {
		System.out.println("==============================="); 
		for(PasswordQuestion name : PasswordQuestion.values()) {
			if(name.getNo()==userVo.getPasswordQuestion()) {
				System.out.println(name.getName());
			}
		}
		System.out.println("===============================");
		return "user/join";
	}
}
