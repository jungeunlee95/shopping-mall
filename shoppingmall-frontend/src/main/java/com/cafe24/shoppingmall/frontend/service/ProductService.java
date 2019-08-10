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
	
	public static final String BACKEND_BASE_URL = "http://localhost:8888/shoppingmall";

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

		String endpoint = BACKEND_BASE_URL+ "/api/product/list";
		
		JSONResultProductList jsonResult = restTemplate.getForObject(endpoint, JSONResultProductList.class);
		
		return jsonResult.getData();
	}
	

	public List<ProductVo> getList(Long page, String keyword) { 
		RestTemplate restTemplate = new RestTemplate();

		String endpoint = BACKEND_BASE_URL+ "/api/product/list/"+page+"?keyword="+keyword;
		
		JSONResultProductList jsonResult = restTemplate.getForObject(endpoint, JSONResultProductList.class);
		
		return jsonResult.getData();
	}
	
	public Boolean addProduct(ProductAddDto pdto) {
		ProductVo productVo = new ProductVo(); 
		productVo.setName(pdto.getName()); 
		productVo.setPrice(pdto.getPrice());
		productVo.setIsShow(pdto.getIsShow());
		productVo.setIsOption(pdto.getIsOption()); 
		productVo.setShippingFee(pdto.getShippingFee());
		productVo.setOrderNo(1);
		productVo.setContents(pdto.getContents());
		productVo.setMainImg(pdto.getMainImgUrl()); 
		productVo.setOptionNameList(pdto.getOptionNameList());
		
		List<CategoryVo> categoryList = new ArrayList<CategoryVo>();
		for(Long no : pdto.getCategoryList()) {
			CategoryVo categoryVo = new CategoryVo();
			categoryVo.setNo(no);
			categoryList.add(categoryVo);
		}	
		productVo.setCategoryList(categoryList);
		
		String uri = BACKEND_BASE_URL+ "/api/admin/product/add";
		HttpEntity<ProductVo> request = new HttpEntity<>(productVo);
		
		ResponseEntity<JSONResultProductAdd> response = restTemplate
				.exchange(uri, HttpMethod.POST, request, JSONResultProductAdd.class);
		
		return response.getBody().getData();
	}

	public ProductVo getDetail(Long no) {
		RestTemplate restTemplate = new RestTemplate();

		String endpoint = BACKEND_BASE_URL+ "/api/product/detail/"+no;
		
		JSONResultProductDetail jsonResult = restTemplate.getForObject(endpoint, JSONResultProductDetail.class);
		
		return jsonResult.getData();
	}
	
	// DTO Class
	private static class JSONResultProductList extends JSONResult<List<ProductVo>> {
	}
	
	private static class JSONResultProductAdd extends JSONResult<Boolean> {
	}
	
	private static class JSONResultProductDetail extends JSONResult<ProductVo> {
	}


}
