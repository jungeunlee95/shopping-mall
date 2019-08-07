package com.cafe24.shoppingmall.frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shoppingmall.frontend.dto.Goods;
import com.cafe24.shoppingmall.frontend.dto.JSONResult;
import com.cafe24.shoppingmall.frontend.dto.ProductAddDto;
import com.cafe24.shoppingmall.frontend.vo.CategoryVo;
import com.cafe24.shoppingmall.frontend.vo.ProductVo;

@Service
public class ProductService {

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
	
	public Boolean addProduct(ProductAddDto pdto) {
		ProductVo productVo = new ProductVo(); 
		productVo.setName(pdto.getName()); 
		productVo.setPrice(pdto.getPrice());
		productVo.setIsShow(pdto.getIsShow());
		productVo.setIsOption(false); 
		productVo.setShippingFee(pdto.getShippingFee());
		productVo.setOrderNo(1);
		productVo.setContents(pdto.getContents());
		productVo.setMainImg(pdto.getMainImgUrl()); 
		
		List<CategoryVo> categoryList = new ArrayList<CategoryVo>();
		for(Long no : pdto.getCategoryList()) {
			CategoryVo categoryVo = new CategoryVo();
			categoryVo.setNo(no);
			categoryList.add(categoryVo);
		}	
		productVo.setCategoryList(categoryList);
		
		String uri = "http://localhost:8888/shoppingmall/api/admin/product/add";
		HttpEntity<ProductVo> request = new HttpEntity<>(productVo);
		
		ResponseEntity<JSONResultProductAdd> response = restTemplate
				.exchange(uri, HttpMethod.POST, request, JSONResultProductAdd.class);
		
		return response.getBody().getData();
	}

	// DTO Class
	private static class JSONResultProductList extends JSONResult<List<ProductVo>> {
	}
	
	private static class JSONResultProductAdd extends JSONResult<Boolean> {
	}

}
