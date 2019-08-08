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

		JSONResultBoolean result = restTemplate.getForObject(endpoint, JSONResultBoolean.class);
		
		return result.getData();
	}
	
	public Boolean joinUser(UserVo userVo) {
		String uri = "http://localhost:8888/shoppingmall/api/nonuser/join";

		HttpEntity<UserVo> request = new HttpEntity<>(userVo);
		
		ResponseEntity<JSONResultBoolean> response = restTemplate
				.exchange(uri, HttpMethod.POST, request, JSONResultBoolean.class);
		
		return response.getBody().getData();
	}
	
	public UserVo loginUser(String id) {
		String uri = "http://localhost:8888/shoppingmall/api/nonuser/login";
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    UserVo vo = new UserVo();
		vo.setId(id);
	    
		JSONResultUser response = restTemplate.postForObject(uri, vo, JSONResultUser.class);
		
		return response.getData();
	}
	
	public Boolean addCart(CartVo cartVo) {
		String uri = "http://localhost:8888/shoppingmall/api/cart/add";
		 
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    JSONResultBoolean response = restTemplate.postForObject(uri, cartVo, JSONResultBoolean.class);
		
		return response.getData();
	}
	
	public Boolean deleteCart(Long no) {
		String uri = "http://localhost:8888/shoppingmall/api/cart/delete";

		System.out.println("1 ------------------------------------"); 
		HttpEntity<Long> request = new HttpEntity<>(no);
		
		ResponseEntity<JSONResultBoolean> response = restTemplate
				.exchange(uri, HttpMethod.DELETE, request, JSONResultBoolean.class);
		System.out.println("2 ------------------------------------");
		
		return response.getBody().getData(); 
	}
	
	public List<CartVo> getUserCartList(Long userNo) {

		String endpoint = "http://localhost:8888/shoppingmall/api/cart/getList/"+userNo;

		JSONResultCartList jsonResult = restTemplate.getForObject(endpoint, JSONResultCartList.class);

		return jsonResult.getData(); 
	}
	
	public UserVo getUserDetail(Long userNo) {
		String endpoint = "http://localhost:8888/shoppingmall/api/admin/user/detail/"+userNo;

		JSONResultUser jsonResult = restTemplate.getForObject(endpoint, JSONResultUser.class);

		return jsonResult.getData();  
	}

	// DTO Class 
	private static class JSONResultUserList extends JSONResult<List<UserVo>> {
	}
	
	private static class JSONResultCartList extends JSONResult<List<CartVo>> {
	}

	private static class JSONResultBoolean extends JSONResult<Boolean> {
	}
	
	private static class JSONResultUser extends JSONResult<UserVo> {
	}



}
