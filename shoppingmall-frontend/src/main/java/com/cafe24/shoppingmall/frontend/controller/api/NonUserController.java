package com.cafe24.shoppingmall.frontend.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.shoppingmall.frontend.dto.JSONResult2;
import com.cafe24.shoppingmall.frontend.service.UserService;

@Controller("nonuserAPIController")
@RequestMapping("/nonuser/api")
public class NonUserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@GetMapping("/checkId")
	public JSONResult2 checkId(@RequestParam(value="id", required=true, defaultValue="") String id) {
		
		Boolean exist = userService.checkId(id);
		
		return JSONResult2.success(exist);
	}
	
	
}
