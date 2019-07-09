package com.cafe24.shoppingmall.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.shoppingmall.dto.JSONResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() { 
		return "hello/hello";
	}

	@ApiOperation(value="스웨거 테스트") 
	@ApiImplicitParams({ 
		@ApiImplicitParam(name="name", value="이름", required=true, dataType="string"),
		@ApiImplicitParam(name="email", value="이메일주소", required=true, dataType="string")
	})
	@RequestMapping(value="/join", method=RequestMethod.POST) 
	public JSONResult checkEmail(
			@RequestParam(value="email", required=true, defaultValue="") String email,
			@RequestParam(value="name", required=true, defaultValue="") String name) {
		return JSONResult.success(null);
	}
}
 