package com.cafe24.shoppingmall.user.controller.api;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.user.vo.UserVo;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@RequestMapping(value="/join", method=RequestMethod.POST) 
	public JSONResult joinUser(@RequestBody UserVo userVo) {
		return JSONResult.success(userVo);
	}
	
	@RequestMapping(value="/checkId", method=RequestMethod.POST) 
	public JSONResult checkId(
			@RequestParam(value="id", required=true, defaultValue="") String id) {
		Boolean exist = false;
		return JSONResult.success(exist);
	} 
	
}
 