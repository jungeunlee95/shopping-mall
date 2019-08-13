package com.cafe24.shoppingmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.dto.OrderDto;
import com.cafe24.shoppingmall.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController("adminOrderAPIController")
@RequestMapping("/api/admin/order") 
public class AdminOrderController {
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value="주문 목록")
	@GetMapping(value="/list") 
	public ResponseEntity<JSONResult> userList() {
		List<OrderDto> list = orderService.getOrderList();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));			
	} 
	
}
