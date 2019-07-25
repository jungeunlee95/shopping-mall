package com.cafe24.shoppingmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.OrderService;
import com.cafe24.shoppingmall.vo.OrderVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value="주문하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="CategoryVo", value="name : 카테고리 이름 \n ", required=true, dataType="CategoryVo", defaultValue="")
	})
	@PostMapping(value="/add") 
	public ResponseEntity<JSONResult> add(@RequestBody OrderVo orderVo) {
		
		Boolean result = orderService.addOrder(orderVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}	
}







 