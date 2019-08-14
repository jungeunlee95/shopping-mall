package com.cafe24.shoppingmall.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.frontend.dto.JSONResult;
import com.cafe24.shoppingmall.frontend.dto.OrderDto;
import com.cafe24.shoppingmall.frontend.vo.OrderDetailVo;

@Service
public class OrderService {
	
	public static final String BACKEND_BASE_URL = "http://localhost:8888/shoppingmall";

	@Autowired
	private OAuth2RestTemplate restTemplate;

	public List<OrderDto> getList() {
		String endpoint = BACKEND_BASE_URL + "/api/admin/order/list"; 

		JSONResultOrderList jsonResult = restTemplate.getForObject(endpoint, JSONResultOrderList.class);

		return jsonResult.getData();
	}
	
	public List<OrderDetailVo> getDetail(Long orderNo) {
		String endpoint = BACKEND_BASE_URL + "/api/order/detail/"+orderNo;

		JSONResultOrderDetail jsonResult = restTemplate.getForObject(endpoint, JSONResultOrderDetail.class);

		return jsonResult.getData();   
	}

	// DTO Class 
	private static class JSONResultOrderList extends JSONResult<List<OrderDto>> {
	}
	
	private static class JSONResultOrderDetail extends JSONResult<List<OrderDetailVo>> {
	}



}
