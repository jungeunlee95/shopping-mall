package com.cafe24.shoppingmall.repository;

import com.cafe24.shoppingmall.vo.UserVo;

public interface UserDao {

	public UserVo insert(UserVo vo);

	public Boolean getId(String id) ;

	public Boolean get(String id, String password);

	public String get(String email);


}
