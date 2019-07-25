package com.cafe24.shoppingmall.controller.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.CartVo;
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
	private CartService cartService;
	
	@ApiOperation(value="장바구니에 상품 추가하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="UserNo", value="UserNo: 회원번호", required=false, dataType="Long", defaultValue=""),
		@ApiImplicitParam(name="nonUserNo", value="nonUserNo: 비회원번호", required=false, dataType="Long", defaultValue=""),
		@ApiImplicitParam(name="productOptionNo", value="productOptionNo: 상품의 옵션 번호", required=true, dataType="Long", defaultValue=""),
		@ApiImplicitParam(name="quantity", value="quantity: 수량", required=true, dataType="Long", defaultValue="")
	})
	@PostMapping(value = "/add")
	public JSONResult addNonUserCart(@RequestBody CartVo cartVo) {
		boolean result = cartService.addCart(cartVo);
		return JSONResult.success(result);
	}
	
	
	@ApiOperation(value="장바구니 목록 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userNo", value="userNo: 회원번호", required=false, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="nonUserNo", value="nonUserId: 비회원번호", required=false, dataType="String", defaultValue="")
	})
	@GetMapping(value = "/getList")
	public JSONResult getCartList(@RequestBody CartVo cartVo) {
		// 상품 list return
		List<CartVo> list = cartService.getCartList(cartVo);
		return JSONResult.success(list);
	}
	
	
 
	
}
 