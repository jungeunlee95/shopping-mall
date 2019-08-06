package com.cafe24.shoppingmall.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shoppingmall.frontend.dto.Goods;
import com.cafe24.shoppingmall.frontend.dto.JSONResult;
import com.cafe24.shoppingmall.frontend.dto.JSONResult2;
import com.cafe24.shoppingmall.frontend.vo.ProductVo;

@Service
public class GoodsService {

	@Autowired
	private OAuth2RestTemplate restTemplate;

//	public Goods getList(Long no) {
//
//		String endpoint = "http://localhost:8888/shoppingmall/api/admin/category/list";
//		JSONResultGoods jsonResult = restTemplate.getForObject(endpoint, JSONResultGoods.class);
//
//		System.out.println(jsonResult);
//
//		return jsonResult.getData();
//	}


	public List<ProductVo> getList() {
		
		RestTemplate restTemplate = new RestTemplate();

		String endpoint = "http://localhost:8888/shoppingmall/api/product/list";
		
		JSONResultProductList jsonResult = restTemplate.getForObject(endpoint, JSONResultProductList.class);
		
		return jsonResult.getData();
	}

	// DTO Class
	private static class JSONResultGoods extends JSONResult<Goods> {
	}

	private static class JSONResultProductList extends JSONResult<List<ProductVo>> {
	}
}
