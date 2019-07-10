package com.cafe24.shoppingmall.user.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.user.service.UserService;
import com.cafe24.shoppingmall.user.vo.UserVo;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/join", method=RequestMethod.POST) 
	public JSONResult joinUser(@RequestBody UserVo userVo) {
		UserVo vo = userService.joinUser(userVo);
		return JSONResult.success(vo);
	}
	

	@RequestMapping(value="/checkId", method=RequestMethod.POST) 
	public JSONResult checkId(
			@RequestBody UserVo userVo) {
		Boolean exist = userService.checkId(userVo.getId());
		return JSONResult.success(exist);
	} 
	

	
}
 