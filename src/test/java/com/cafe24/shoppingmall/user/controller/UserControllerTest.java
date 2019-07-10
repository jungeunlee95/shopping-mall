package com.cafe24.shoppingmall.user.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.user.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class UserControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testJoinUser() throws Exception {

		UserVo userVo = new UserVo();
		userVo.setId("testId");
		userVo.setName("testUser");
		userVo.setPassword("1234");
		userVo.setPasswordQuestion("가장 아끼는 보물은?");
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com");
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data.name", is(userVo.getName())))
		.andExpect(jsonPath("$.data.phoneNumber", is(userVo.getPhoneNumber())));
	}
	
	@Test
	public void testCheckId() throws Exception {

		UserVo userVo = new UserVo();
		userVo.setId("leeap1004@gmail.com");
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/checkId")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data", is(false))); 
        //  false : 회원가입 가능, true : 중복 아이디 존재
	}
	
	@Test
	public void testlogin() throws Exception {

		UserVo userVo = new UserVo();
		userVo.setId("userId");
		userVo.setPassword("userPW");
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/login")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data", is(false))); 
        //  false : 로그인 실패, true : 로그인 가능
	}
	
	@Test
	public void findId() throws Exception {

		String email = "leeap1004@gmail.com";
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/findId")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(email)));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ));
//		.andExpect(jsonPath("$.data", is(false))); 
        //  false : 로그인 실패, true : 로그인 가능
	}
}
















