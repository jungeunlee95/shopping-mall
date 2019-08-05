package com.example.shoppingmall.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
