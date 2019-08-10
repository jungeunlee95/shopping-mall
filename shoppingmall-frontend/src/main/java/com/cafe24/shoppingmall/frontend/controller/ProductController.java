package com.cafe24.shoppingmall.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.shoppingmall.frontend.service.CategoryService;
import com.cafe24.shoppingmall.frontend.service.ProductService;
import com.cafe24.shoppingmall.frontend.vo.CategoryVo;
import com.cafe24.shoppingmall.frontend.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
//	@ResponseBody 
//	@RequestMapping("/list")
//	public String list(Model model) {
//		List<ProductVo> list = productService.getList();
//		model.addAttribute("productList", list);
//		return "ok";
//	}  
	
	@RequestMapping("/{no}")
	public String detail(@PathVariable("no") Long no, Model model) {
		
		List<CategoryVo> cList = categoryService.getLowList();
		model.addAttribute("categoryList", cList);
		
		ProductVo product = productService.getDetail(no);
		model.addAttribute("product", product);
		return "goods/item";
	}   
	 
	@RequestMapping("/list/{categoryNo}")  
	public String list(@PathVariable("categoryNo") Long categoryNo,  
						@RequestParam(value="keyword", required = false, defaultValue = "") String keyword,
						Model model) {  
		List<CategoryVo> cList = categoryService.getLowList(); 
		model.addAttribute("categoryList", cList);
		
		List<ProductVo> pList  = productService.getList(); 
		model.addAttribute("productList", pList);  
		return "goods/product-list";
	}

}
