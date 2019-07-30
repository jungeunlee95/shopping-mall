package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.OrderService;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value="회원 주문하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="OrderVo", 
				value="userNo : 회원번호 \n "
				+ "name : 비회원 이름\n "
				+ "gender : 성별 \n "
				+ "phoneNumber : 전화번호 \n "
				+ "email : 이메일 \n "
				+ "address : address \n "
				+ "totalPrice : 가격 \n "
				+ "message : 배송매세지 \n ", required=true, dataType="OrderVo", defaultValue="")
	})
	@PostMapping(value="/add") 
	public ResponseEntity<JSONResult> add(@RequestBody OrderVo orderVo) {
		
		Boolean result = orderService.addOrder(orderVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}	
	
	@ApiOperation(value="회원 주문 목록 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="OrderVo", value="no : 주문 PK번호 \n ", required=true, dataType="OrderVo", defaultValue="")
	})
	@GetMapping(value="/list") 
	public ResponseEntity<JSONResult> getList(@RequestBody OrderVo orderVo) {
		List<OrderVo> list = orderService.getOrderListByNo(orderVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	} 
	
	@ApiOperation(value="회원 주문 상세 목록 가져오기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", 
				value="no : 주문 PK 번호 ", required=true, dataType="OrderVo", defaultValue="")
	})
	@GetMapping(value="/detail/{no}") 
	public ResponseEntity<JSONResult> getOrderDetailList(@PathVariable(value="no") Long no) {
		
		List<OrderDetailVo> list = orderService.getOrderDetailList(no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	} 
}







 