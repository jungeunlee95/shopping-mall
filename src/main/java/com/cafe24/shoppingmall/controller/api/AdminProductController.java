package com.cafe24.shoppingmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("adminProductAPIController")
@RequestMapping("/api/admin/product") 
//@Admin
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@ApiOperation(value="상품 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="name", value="name : 아이디", required=true, dataType="String", defaultValue="")
	})
	@GetMapping(value="/add") 
	public ResponseEntity<JSONResult> addProduct(@RequestBody ProductVo productVo) {
		
		Boolean result = productService.addProduct(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	@ApiOperation(value="상품 상위 옵션 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="name", value="name : 옵션이름", required=true, dataType="String", defaultValue="")
	})
	@GetMapping(value="/addOption") 
	public ResponseEntity<JSONResult> addOption(@RequestBody OptionVo optionVo) {
		
		OptionVo result = productService.addOption(optionVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	

}
