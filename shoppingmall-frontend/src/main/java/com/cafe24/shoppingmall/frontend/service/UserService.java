package com.cafe24.shoppingmall.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.frontend.dto.JSONResult;
import com.cafe24.shoppingmall.frontend.vo.CartVo;
import com.cafe24.shoppingmall.frontend.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private OAuth2RestTemplate restTemplate;

	public List<UserVo> getUserList() {

		String endpoint = "http://localhost:8888/shoppingmall/api/admin/user/list";

		JSONResultUserList jsonResult = restTemplate.getForObject(endpoint, JSONResultUserList.class);

		return jsonResult.getData();
	}
	
	public Boolean checkId(String id) {
		String endpoint = "http://localhost:8888/shoppingmall/api/nonuser/checkId?id="+id;

		JSONResultUserCheckId result = restTemplate.getForObject(endpoint, JSONResultUserCheckId.class);
		
		return result.getData();
	}
	
	public Boolean joinUser(UserVo userVo) {
		String uri = "http://localhost:8888/shoppingmall/api/nonuser/join";

		HttpEntity<UserVo> request = new HttpEntity<>(userVo);
		
		ResponseEntity<JSONResultUserJoin> response = restTemplate
				.exchange(uri, HttpMethod.POST, request, JSONResultUserJoin.class);
		
		return response.getBody().getData();
	}
	
	public UserVo loginUser(String id) {
		String uri = "http://localhost:8888/shoppingmall/api/nonuser/login";
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    UserVo vo = new UserVo();
		vo.setId(id);
	    
		JSONResultUserLogin response = restTemplate.postForObject(uri, vo, JSONResultUserLogin.class);
		
		return response.getData();
	}
	
	public Boolean addCart(CartVo cartVo) {
		String uri = "http://localhost:8888/shoppingmall/api/cart/add";
		 
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
		JSONResultUseraddCart response = restTemplate.postForObject(uri, cartVo, JSONResultUseraddCart.class);
		
		return response.getData();
	}
	
	public List<CartVo> getUserCartList(Long userNo) {

		String endpoint = "http://localhost:8888/shoppingmall/api/cart/getList/"+userNo;

		JSONResultCartList jsonResult = restTemplate.getForObject(endpoint, JSONResultCartList.class);

		return jsonResult.getData(); 
	}

	// DTO Class 
	private static class JSONResultUserList extends JSONResult<List<UserVo>> {
	}
	
	private static class JSONResultCartList extends JSONResult<List<CartVo>> {
	}

	private static class JSONResultUserJoin extends JSONResult<Boolean> {
	}
	
	private static class JSONResultUserCheckId extends JSONResult<Boolean> {
	}
	
	private static class JSONResultUserLogin extends JSONResult<UserVo> {
	}
	
	private static class JSONResultUseraddCart extends JSONResult<Boolean> {
	}

}
