package com.cafe24.shoppingmall.user.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.user.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired 
	private SqlSession sqlSession;

}
