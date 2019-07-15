package com.cafe24.shoppingmall.controller.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("cartAPIController")
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CartService CartService;
	
	@ApiOperation(value="장바구니 목록 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId", value="userId: 회원아이디", required=true, dataType="String", defaultValue="")
	})
	@GetMapping(value = "/{userId}")
	public JSONResult getCartList(@PathVariable(value="userId") String userId) {
		
		// 상품 list return
		List<ProductVo> list = productService.getProductList(userId);
		return JSONResult.success(list);
	}

	@ApiOperation(value="장바구니에 상품 추가하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId", value="userId: 회원아이디", required=true, dataType="String", defaultValue=""),
		@ApiImplicitParam(name="optionNo", value="optionNo: 상품의 옵션 번호", required=true, dataType="Long", defaultValue="")
	})
	@PostMapping(value = "/{userId}/{optionNo}")
	public JSONResult addCart(@PathVariable(value="userId") String userId,
							  @PathVariable(value="optionNo") Long optionNo) {
		// 해당 회원(userId)의 장바구니에 상품(optionNo)추가
		boolean result = CartService.addCart(userId, optionNo);
		return JSONResult.success(result);
	}
	
	/**
	 * 해당 회원의 상품(cartNo)의 옵션 변경(optionNo : 변경 할 수량)
	 * 해당 회원의 상품(cartNo)의 옵션 수량 변경(quantity : 변경 할 수량)
	 * @param userId: 유저 아이디
	 * @param cartNo: 
	 * @param optionNo
	 * @param quantity
	 * @return 
	 */
	@ApiOperation(value="장바구니 옵션/수량 수정하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId", value="userId: 회원아이디", required=true, dataType="String", defaultValue=""),
		@ApiImplicitParam(name="cartNo", value="cartNo: 장바구니에 담긴 상품번호", required=true, dataType="Long", defaultValue=""),
		@ApiImplicitParam(name="optionNo", value="optionNo: 상품의 옵션 번호", required=true, dataType="Long", defaultValue=""),
		@ApiImplicitParam(name="quantity", value="quantity: 상품의 수량", required=true, dataType="Long", defaultValue="")
	})
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
	
	@ApiOperation(value="장바구니 상품 삭제하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId", value="userId: 회원아이디", required=true, dataType="String", defaultValue=""),
		@ApiImplicitParam(name="cartNo", value="cartNo: 장바구니에 담긴 상품번호", required=true, dataType="Long", defaultValue="")
	})
	@DeleteMapping(value = "/delete/{userId}/{cartNo}")
	public JSONResult deleteCart(
			@PathVariable(value="userId") String userId,
			@PathVariable(value="cartNo") Long cartNo) {
		
		boolean result = CartService.deleteCart(userId, cartNo);
		
		return JSONResult.success(result);
	}
	
	
 
	
}
 