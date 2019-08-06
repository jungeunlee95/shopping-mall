package com.cafe24.shoppingmall.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.shoppingmall.frontend.service.GoodsService;
import com.cafe24.shoppingmall.frontend.service.UserService;
import com.cafe24.shoppingmall.frontend.vo.ProductVo;
import com.cafe24.shoppingmall.frontend.vo.UserVo;

@Controller
@RequestMapping( "/admin"  )
public class AdminController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping( "" )
	public String login() {
		return "admin/main";
	}

	@GetMapping( "/user/list" )
	public String userList(Model model) {
		List<UserVo> list = userService.getUserList();
		model.addAttribute("userList", list);
		return "admin/user-list";
	}
	
	@GetMapping( "/product" )
	public String product() {
		return "admin/add-product"; 
	}
	
	@GetMapping( "/product/list" )
	public String productList(Model model) {
		List<ProductVo> list = goodsService.getList();
		model.addAttribute("productList", list);
		return "admin/product-list";
	}
	
}
