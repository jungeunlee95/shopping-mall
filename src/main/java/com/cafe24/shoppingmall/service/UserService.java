package com.cafe24.shoppingmall.service;
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
		UserVo vo =  userDao.getId(id);
		Boolean exist = vo==null;
		return exist;
	}

	public UserVo getUser(String id, String password) {
		UserVo vo  = userDao.get(id, password);
		System.out.println("+++++++" + vo);
		return vo;
	}

	public UserVo getUser(String email) {
		UserVo userVo = userDao.get(email);
		return userVo;
	} 

}
