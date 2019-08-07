package com.cafe24.shoppingmall.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.shoppingmall.frontend.service.ProductService;
import com.cafe24.shoppingmall.frontend.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(Model model) {
		List<ProductVo> list = productService.getList();
		model.addAttribute("productList", list);
		return "ok";
	}
	
	@RequestMapping("{no}")
	public String list(@PathVariable("no") Long no) {
		return "goods/item";
	}

}
