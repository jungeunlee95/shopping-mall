package com.cafe24.shoppingmall.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.UserDao;
import com.cafe24.shoppingmall.vo.UserVo;

@Service
public class UserService{
	@Autowired
	private UserDao userDao;
	
	public UserVo joinUser(UserVo userVo) {
		UserVo vo = userDao.insert(userVo);
		return vo;
	}
	
	public Boolean checkId( String id) {
		Boolean exist = userDao.getId(id);
		return exist;
	}

	public Boolean getUser(String id, String password) {
		Boolean exist = userDao.get(id, password);
		return exist;
	}

	public String getUser(String email) {
		String userId = userDao.get(email);
		return userId;
	} 

}
