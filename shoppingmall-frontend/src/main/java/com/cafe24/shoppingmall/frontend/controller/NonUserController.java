package com.cafe24.shoppingmall.frontend.controller;

import java.util.ArrayList;
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

import com.cafe24.shoppingmall.frontend.security.AuthUser;
import com.cafe24.shoppingmall.frontend.security.SecurityUser;
import com.cafe24.shoppingmall.frontend.service.CategoryService;
import com.cafe24.shoppingmall.frontend.service.UserService;
import com.cafe24.shoppingmall.frontend.vo.CartVo;
import com.cafe24.shoppingmall.frontend.vo.CategoryVo;
import com.cafe24.shoppingmall.frontend.vo.UserVo;

@Controller
@RequestMapping("/nonuser")
public class NonUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	

	@GetMapping("/login")
	public String login() {
		return "user/login"; 
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		return "user/join";
	}

	@PostMapping("/join")
	public String join(@ModelAttribute("userVo") @Valid UserVo userVo, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> list = bindingResult.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error);
			}
			model.addAllAttributes(bindingResult.getModel());
			return "user/join";
		}
		
		Boolean result = userService.joinUser(userVo);
		
		model.addAttribute("result", result); 

		return "user/join-success";

//		System.out.println("==============================="); 
//		for(PasswordQuestion name : PasswordQuestion.values()) {
//			if(name.getNo()==userVo.getPasswordQuestion()) {
//				System.out.println(name.getName());
//			}
//		}
//		System.out.println("===============================");
	}
	
	
	@GetMapping("/cart")
	public String cart(Model model,  @AuthUser SecurityUser securityUser) { 
		List<CategoryVo> cList = categoryService.getLowList();
		model.addAttribute("categoryList", cList); 
		
		List<CartVo> cartList = null;   
		if(securityUser!=null) {
			cartList = userService.getUserCartList(securityUser.getNo());
		} 
		model.addAttribute("cartList", cartList); 
			  
		return "goods/cart"; 
	}
	
}
