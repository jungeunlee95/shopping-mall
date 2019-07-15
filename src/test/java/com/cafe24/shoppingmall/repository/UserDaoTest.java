package com.cafe24.shoppingmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cafe24.shoppingmall.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserDaoTest {

	@Autowired 
	private SqlSession sqlSession;
	
	@Test
	public void testJoinUser() throws Exception {
		UserVo userVo = new UserVo();
		userVo.setId("leeap1004");
		userVo.setName("이정은");
		userVo.setPassword("Wjddms1234");
		userVo.setPasswordQuestion("1");
		userVo.setPasswordAnswer("핸드폰");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com");
		userVo.setBirthDate("1995-11-29");
		userVo.setPoint("0");
		userVo.setGender("F");
		
		int result = sqlSession.insert("user_test.insert", userVo);
	}
}






