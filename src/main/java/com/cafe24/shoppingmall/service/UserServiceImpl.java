package com.cafe24.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.UIEvent;

import com.cafe24.shoppingmall.repository.UserDaoImpl;
import com.cafe24.shoppingmall.vo.UserVo;

@Service
public class UserServiceImpl{
	
	@Autowired
	private UserDaoImpl userDao;
	
	public UserVo joinUser(UserVo userVo) {
		System.out.println("들어가기전 !!!!");
		UserVo vo = userDao.insert(userVo);
		System.out.println("들어갔다옴!@!@!@!!!!");
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
