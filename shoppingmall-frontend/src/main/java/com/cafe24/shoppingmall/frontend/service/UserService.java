package com.cafe24.shoppingmall.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		JSONResultUserList jsonResult = new RestTemplate().getForObject(endpoint, JSONResultUserList.class);
		
		return jsonResult.getData();
	}

	public Boolean joinUser(UserVo userVo) {
		String endpoint = "http://localhost:8888/shoppingmall/api/nonuser/join";
		
		JSONResultUserJoin jsonResult = new RestTemplate().getForObject(endpoint, JSONResultUserJoin.class);
		
		return jsonResult.getData();
	}
	
	// DTO Class
	private static class JSONResultUserList extends JSONResult<List<UserVo>> {}
	private static class JSONResultUserJoin extends JSONResult<Boolean> {}

}
