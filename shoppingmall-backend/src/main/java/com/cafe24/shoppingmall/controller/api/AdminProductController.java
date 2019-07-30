package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OptionValueVo;
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
		@ApiImplicitParam(name="ProductVo", 
				value="name: 상품이름  \n "
					+ "price: 가격 \n "
					+ "isShow: 진열여부 \n "
					+ "isOption: 옵션여부 \n "
					+ "shippingFee: 배송비 \n "
					+ "orderNo: 진열순서 \n "
					+ "contents: 본문내용 \n "
					+ "List<CategoryVo>: 카테고리 리스트 \n "
					+ "List<OptionValueVo>: 등록할 옵션 리스트 \n "					
				, required=true, dataType="ProductVo", defaultValue="")
	})
	@PostMapping(value="/add") 
	public ResponseEntity<JSONResult> addProduct(@RequestBody ProductVo productVo) {
		Boolean result = productService.addProduct(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	@ApiOperation(value="상품 상위 옵션 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="OptionVo", value="name : 상위 옵션 이름", required=true, dataType="OptionVo", defaultValue="")
	})
	@PostMapping(value="/addOption") 
	public ResponseEntity<JSONResult> addOption(@RequestBody OptionVo optionVo) {
		
		OptionVo result = productService.addOption(optionVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	
	@ApiOperation(value="최종 옵션 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="List<OptionNameVo>", 
				value="최종 상품값 정보 리스트 \n"
						+ "productNo : 상품 번호"
						+ "productOptionName : 상품 옵션 이름"
						+ "additionalAmount : 추가 금액"
						+ "useStock : 재고 사용 여부"
						+ "stock : 재고", 
						required=true, dataType="List<OptionNameVo>", defaultValue="")
	})
	@PostMapping(value="/addProductOption") 
	public ResponseEntity<JSONResult> addProductOption(@RequestBody List<OptionNameVo> optionNameVoList) {
		Boolean result = productService.addProductOption(optionNameVoList);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	
	@ApiOperation(value="상품 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="상품 번호", required=true, dataType="Long", defaultValue="")
	})
	@DeleteMapping(value="/delete/{no}") 
	public ResponseEntity<JSONResult> deleteProduct(@PathVariable(value="no") Long no) {
		
		Boolean result = productService.deleteProduct(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	@ApiOperation(value="상품 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="ProductVo", 
				value="no : 상품 번호 \n"
					+ "name: 상품이름  \n "
					+ "price: 가격 \n "
					+ "isShow: 진열여부 \n "
					+ "isOption: 옵션여부 \n "
					+ "shippingFee: 배송비 \n "
					+ "orderNo: 진열순서 \n "
					+ "contents: 본문내용 \n "
					+ "List<CategoryVo>: 카테고리 리스트 \n "
					+ "List<OptionValueVo>: 등록할 옵션 리스트 \n "					
				, required=true, dataType="ProductVo", defaultValue="")
	})
	@PutMapping(value="/modify") 
	public ResponseEntity<JSONResult> modifyProduct(@RequestBody ProductVo productVo) {
		
		ProductVo result = productService.modifyProduct(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	
	@ApiOperation(value="상품 옵션 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="List<OptionValueVo>", 
				value="no : 옵션번호 \n"
					+ "value : 변경할 옵션 이름", required=true, dataType="List<OptionValueVo>", defaultValue="")
	})
	@PutMapping(value="/modifyOptionValue/{productNo}") 
	public ResponseEntity<JSONResult> modifyOptionValue(
			@RequestBody List<OptionValueVo> optionValueVoList,
			@PathVariable(value="productNo") Long productNo) {
		
		boolean result = productService.modifyOptionValue(productNo, optionValueVoList);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	} 
	

}
