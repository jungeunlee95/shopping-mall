package com.cafe24.shoppingmall.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shoppingmall.frontend.dto.JSONResult;
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
	
	public Boolean joinUser(UserVo userVo) {
		String uri = "http://localhost:8888/shoppingmall/api/nonuser/join";

		HttpEntity<UserVo> request = new HttpEntity<>(userVo);
		
		ResponseEntity<JSONResultUserJoin> response = restTemplate
				.exchange(uri, HttpMethod.POST, request, JSONResultUserJoin.class);
		
		return response.getBody().getData();
		
		
		// ------------------------- 1 ---------------------------
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		HttpEntity<UserVo> entity = new HttpEntity<UserVo>(userVo, headers);
//		return restTemplate.postForObject(uri, entity, String.class);
		// ------------------------------------------------------


		// ------------------------- 2 ---------------------------
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.valueOf("text/plain;charset=utf-8"));
//		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)" +
//		" AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//
//		ResponseEntity<JSONResultUserJoin> response = restTemplate.exchange(uri, HttpMethod.POST, null,
//				new ParameterizedTypeReference<JSONResultUserJoin>() {
//				}, userVo);
//
//		// Verify request succeed
//		System.out.println("===================================");
//		System.out.println(response.getBody().getData());
//		System.out.println("===================================");
		// ------------------------------------------------------
		
		
		// ------------------------- 3 ---------------------------
		//String endpoint = "http://localhost:8888/shoppingmall/api/nonuser/join";
		//JSONResultUserJoin jsonResult = new RestTemplate().postForObject(uri, userVo, JSONResultUser.class);
		// ------------------------------------------------------
		// return true;
	}

	// DTO Class
	private static class JSONResultUserList extends JSONResult<List<UserVo>> {
	}

	private static class JSONResultUserJoin extends JSONResult<Boolean> {
	}

}
