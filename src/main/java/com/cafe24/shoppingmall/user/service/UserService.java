package com.cafe24.shoppingmall.user.service;

import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.user.vo.UserVo;

@Service
public class UserService {
	
	public UserVo joinUser(UserVo userVo) {
		return userVo;
	}
	
	public Boolean checkId( String id) {
		Boolean exist = false;
		return exist;
	} 

}
