package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.impl.ProductServiceImpl;
import com.cafe24.shoppingmall.vo.ProductVo;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@RequestMapping(value = "/{categoryNo}", method = RequestMethod.GET)
	public JSONResult getProductList(@PathVariable(value = "categoryNo") Long categoryNo,
			@RequestParam(value="keyword", required = false, defaultValue = "") String keyword) {
		
		// 해당 카테고리의 list return
		List<ProductVo> list = productService.getProductList(categoryNo, keyword);
		return JSONResult.success(list);
	}

}
