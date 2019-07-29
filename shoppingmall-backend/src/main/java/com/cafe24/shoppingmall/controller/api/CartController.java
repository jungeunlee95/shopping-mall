package com.cafe24.shoppingmall.controller.api;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.dto.RequestDeleteCartDto;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.CartVo;

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
		@ApiImplicitParam(name="userNo", value="userNo: 회원번호", required=false, dataType="long", defaultValue="")
	})
	@GetMapping(value = "/getList")
	public JSONResult getCartList(@RequestBody CartVo cartVo) {
		// 상품 list return
		List<CartVo> list = cartService.getCartList(cartVo);
		return JSONResult.success(list);
	}
	
	@ApiOperation(value="장바구니 상품 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="no: 장바구니 번호", required=true, dataType="long", defaultValue="")
		
	})
	@DeleteMapping(value = "/delete")
	public ResponseEntity<JSONResult> deleteCart(@RequestBody @Valid List<RequestDeleteCartDto> noList
			, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError error : allErrors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		Boolean result = cartService.deleteCart(noList);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	
 
	
}
 