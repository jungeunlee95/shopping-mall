package com.cafe24.shoppingmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.test.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserDaoTest {
	
	@Autowired 
	private SqlSession sqlSession;

	@Test
	public void testJoinUser() throws Exception {
		
	}
}





