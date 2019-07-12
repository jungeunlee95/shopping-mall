package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.vo.UserVo;

public interface UserService {
	
	public UserVo joinUser(UserVo userVo);
	
	public Boolean checkId( String id);
	
	public Boolean getUser(String id, String password);

	public String getUser(String email);

}
