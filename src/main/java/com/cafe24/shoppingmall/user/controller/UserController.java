package com.cafe24.shoppingmall.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.user.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
    
    @RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() { 
		return "hello/hello";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST) 
	public JSONResult checkEmail(
			@RequestParam(value="email", required=true, defaultValue="") String email,
			@RequestParam(value="name", required=true, defaultValue="") String name) {
		return JSONResult.success(null);
	}
}
 