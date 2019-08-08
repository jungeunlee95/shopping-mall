package com.cafe24.shoppingmall.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.shoppingmall.frontend.service.CategoryService;
import com.cafe24.shoppingmall.frontend.service.ProductService;
import com.cafe24.shoppingmall.frontend.vo.CategoryVo;
import com.cafe24.shoppingmall.frontend.vo.ProductVo;

@Controller
public class MainController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping( {"/", "/main"} )
	public String main(Model model) {
		List<CategoryVo> cList = categoryService.getLowList();
		model.addAttribute("categoryList", cList);
		
		List<ProductVo> pList  = productService.getList();
		model.addAttribute("productList", pList);
		return "main/index";
	}
}
