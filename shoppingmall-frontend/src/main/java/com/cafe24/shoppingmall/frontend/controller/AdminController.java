package com.cafe24.shoppingmall.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.shoppingmall.frontend.dto.ProductAddDto;
import com.cafe24.shoppingmall.frontend.service.CategoryService;
import com.cafe24.shoppingmall.frontend.service.FileuploadService;
import com.cafe24.shoppingmall.frontend.service.ProductService;
import com.cafe24.shoppingmall.frontend.service.UserService;
import com.cafe24.shoppingmall.frontend.vo.CategoryVo;
import com.cafe24.shoppingmall.frontend.vo.ProductVo;
import com.cafe24.shoppingmall.frontend.vo.UserVo;

@Controller
@RequestMapping( "/admin"  )
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private FileuploadService fileuploadService;
	
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
	public String product(Model model) {
		List<CategoryVo> list = categoryService.getLowList();
		model.addAttribute("categoryLowList", list);
		return "admin/add-product"; 
	}
	
	@GetMapping( "/product/list" )
	public String productList(Model model) {
		List<ProductVo> list = productService.getList();
		model.addAttribute("productList", list);
		return "admin/product-list";
	} 
	
	@PostMapping( "/product/add" )  
	public String productAdd( 
			@RequestParam(value="mainImg", required = false) MultipartFile multipartFile,
			Model model, 
			@ModelAttribute ProductAddDto pdto) { 
		String url = fileuploadService.restore(multipartFile);
		pdto.setMainImgUrl(url);
		Boolean result = productService.addProduct(pdto);
		
		model.addAttribute("result", result); 
 
		return  "redirect:/admin/product/list";
	}
	
}
