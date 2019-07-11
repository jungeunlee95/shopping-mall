package com.cafe24.shoppingmall.product.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.product.service.ProductService;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value="", method=RequestMethod.GET) 
	public JSONResult getProductList() {
	      return JSONResult.success(null);
	}

	
}
 