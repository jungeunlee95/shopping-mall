package com.cafe24.shoppingmall.user.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.cafe24.shoppingmall.config.test.AppConfig;
import com.cafe24.shoppingmall.config.test.WebConfig;
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, WebConfig.class})
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

		UserVo userVo = new UserVo("testId", "testUser", "dlwjddmsWKd11!", "가장 아끼는 보물은?", "수첩", "010-9274-3036", "leeap1004");
		
		// 이메일 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 이메일 형식입니다.") ));
		
		// 비밀번호 검사
		userVo.setPassword("1234");
		userVo.setEmail("leeap1004@gmail.com");
		
		ResultActions resultActions2 = 
				mockMvc
				.perform(post("/api/user/join")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions2 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 비밀번호 형식입니다.") ));
		
		// 이름 검사
		userVo.setPassword("WjddmsWkd1!");
		userVo.setName("이d은a");
		 
		ResultActions resultActions3 = 
				mockMvc
				.perform(post("/api/user/join")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions3
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 이름 형식입니다.") ));
		
		// 전화번호 검사
		userVo.setName("이정은");
		userVo.setPhoneNumber("5--1588-4-4");
		ResultActions resultActions4 = 
				mockMvc
				.perform(post("/api/user/join")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions4
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 전화번호 형식입니다.") ));
		
		// 회원가입 성공
		userVo.setPhoneNumber("010-9274-3036");
		ResultActions resultActions5 = 
				mockMvc
				.perform(post("/api/user/join") 
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions5
		.andExpect(status().isOk()).andDo(print());
		

	}
	
	@Test
	public void testCheckId() throws Exception {

		String id = "userId";
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/user/checkId?id={id}", id)
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data", is(false))); 
        //  false : 회원가입 가능, true : 중복 아이디 존재
	}
	
	@Test
	public void testlogin() throws Exception {

		String id = "userId";
		String password = "userPW123!";
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/user/login?id={id}&password={password}", id, password)
				.contentType(MediaType.APPLICATION_JSON));
		
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
				.perform(get("/api/user/findId?email={email}", email)
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data", is(email))); 
	}
}
















