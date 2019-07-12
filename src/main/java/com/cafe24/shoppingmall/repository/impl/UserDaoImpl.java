package com.cafe24.shoppingmall.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.repository.UserDao;
import com.cafe24.shoppingmall.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired 
	private SqlSession sqlSession;

	public UserVo insert(UserVo vo) {
		return vo;
	}

	public Boolean getId(String id) {
		return false;
	}

	public Boolean get(String id, String password) {
		return false;
	}

	public String get(String email) {
		return email;
	}


}
