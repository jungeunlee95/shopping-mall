package com.cafe24.shoppingmall.controller.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;

@RestController("cartAPIController")
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CartService CartService;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public JSONResult getCartList(@PathVariable(value="userId") String userId) {
		
		// 상품 list return
		List<ProductVo> list = productService.getProductList(userId);
		return JSONResult.success(list);
	}
	
	@RequestMapping(value = "/{userId}/{optionNo}", method = RequestMethod.POST)
	public JSONResult addCart(@PathVariable(value="userId") String userId,
							  @PathVariable(value="optionNo") Long optionNo) {
		// 해당 회원(userId)의 장바구니에 상품(optionNo)추가
		boolean result = CartService.addCart(userId, optionNo);
		return JSONResult.success(result);
	}
	
	/**
	 * 해당 회원의 상품(cartNo)의 옵션 변경(optionNo : 변경 할 수량)
	 * 해당 회원의 상품(cartNo)의 옵션 수량 변경(quantity : 변경 할 수량)
	 * @param userId
	 * @param cartNo
	 * @param optionNo
	 * @param quantity
	 * @return
	 */
	@RequestMapping(value = "/modify/{userId}/{cartNo}", method = RequestMethod.POST)
	public JSONResult modifyCart(
			@PathVariable(value="userId") String userId,
			@PathVariable(value="cartNo") Long cartNo,
			@RequestParam(value="optionNo", required = false, defaultValue = "0") Long optionNo,
			@RequestParam(value="quantity", required = false, defaultValue = "0") Long quantity) {
		boolean result = false;
		
		if(optionNo!=0) {
			// 해당 회원(userId)의 장바구니에 상품(optionNo)추가
			result = CartService.modifyCartOption(userId, cartNo, optionNo);			
		}else if(quantity!=0) {
			// 해당 회원(userId)의 장바구니에 상품(optionNo)추가
			result = CartService.modifyCartQuantity(userId, cartNo, quantity);
		}
		return JSONResult.success(result);
	}
	
	@RequestMapping(value = "/delete/{userId}/{cartNo}", method = RequestMethod.DELETE)
	public JSONResult deleteCart(
			@PathVariable(value="userId") String userId,
			@PathVariable(value="cartNo") Long cartNo) {
		
		boolean result = CartService.deleteCart(userId, cartNo);
		
		return JSONResult.success(result);
	}
	
	

	
}
 