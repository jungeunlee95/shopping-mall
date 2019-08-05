package com.example.shoppingmall.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.frontend.dto.Goods;
import com.example.shoppingmall.frontend.dto.JSONResult;

@Service
public class GoodsService {
	
	@Autowired
	private OAuth2RestTemplate restTemplate;

	
	public Goods getList(Long no){
		
		String endpoint = "http://localhost:8088/shoppingmall/api/admin/category/list";
		JSONResultGoods jsonResult = restTemplate.getForObject(endpoint, JSONResultGoods.class);
		
		System.out.println( jsonResult );
		
		return jsonResult.getData();
	}
	
	public String getList(){
		
		String endpoint = "http://localhost:8088/shoppingmall/api/admin/category/list";
		JSONResultGoodsList jsonResult = restTemplate.getForObject(endpoint, JSONResultGoodsList.class);

		System.out.println("======================================");
		System.out.println( jsonResult );
		System.out.println("======================================");
		
		return jsonResult.getData(); 
	}
	
	// DTO Class
	private class JSONResultGoods extends JSONResult<Goods>{
	}
	private class JSONResultGoodsList extends JSONResult<String>{
	}
}




