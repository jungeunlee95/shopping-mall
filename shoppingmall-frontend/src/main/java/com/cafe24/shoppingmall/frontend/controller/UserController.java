package com.cafe24.shoppingmall.frontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.shoppingmall.frontend.dto.OrderDto;
import com.cafe24.shoppingmall.frontend.security.AuthUser;
import com.cafe24.shoppingmall.frontend.security.SecurityUser;
import com.cafe24.shoppingmall.frontend.service.UserService;
import com.cafe24.shoppingmall.frontend.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/order") 
	public String order(OrderDto orderDto, Model model, @AuthUser SecurityUser securityUser) { 

		Boolean result = userService.userOrder(orderDto, securityUser);
 
		return "user/order-success"; 
	}
}
