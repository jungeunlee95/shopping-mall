package com.cafe24.shoppingmall.controller.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;

@RestController("mainAPIController")
@RequestMapping("/api/main")
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public JSONResult getProductList() {
		
		// 상품 list return
		List<ProductVo> list = productService.getProductList();
		return JSONResult.success(list);
	}
	

	
}
 