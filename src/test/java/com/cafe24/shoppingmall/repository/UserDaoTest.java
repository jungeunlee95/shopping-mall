package com.cafe24.shoppingmall.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cafe24.shoppingmall.vo.UserVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

	@Autowired 
	private SqlSession sqlSession;
	
	@Test
	public void testJoinUser() throws Exception {
		sqlSession.delete("user_test.delete");
		assertThat(sqlSession.selectOne("user_test.count"), is(0));
		
		UserVo userVo = new UserVo();
		userVo.setId("leeap1004");
		userVo.setName("이정은");
		userVo.setPassword("Wjddms1234");
		userVo.setPasswordQuestion(1);
		userVo.setPasswordAnswer("핸드폰");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com");
		userVo.setBirthDate("1995-11-29");
		userVo.setPoint("0");
		userVo.setGender("F");
		
		sqlSession.insert("user_test.insert", userVo);
		assertThat(sqlSession.selectOne("user_test.count"), is(1));
		
		userVo.setId("leeap10042");
		userVo.setName("이정은2");
		userVo.setPassword("Wjddms12342");
		userVo.setPasswordQuestion(12);
		userVo.setPasswordAnswer("핸드폰2");
		userVo.setPhoneNumber("010-9274-30362");
		userVo.setEmail("aaa@gmail.com");
		userVo.setBirthDate("1995-11-30");
		userVo.setPoint("20");
		userVo.setGender("F");
		
		sqlSession.insert("user_test.insert", userVo);
		assertThat(sqlSession.selectOne("user_test.count"), is(2));
		
		List<UserVo> list = sqlSession.selectList("user_test.userList");
		assertThat(list.get(0).getName(), is("이정은"));
		assertThat(list.get(1).getName(), is("이정은2"));
		assertThat(list.get(0).getBirthDate(), is("1995-11-29"));
		assertThat(list.get(1).getBirthDate(), is("1995-11-30"));

	}
}






