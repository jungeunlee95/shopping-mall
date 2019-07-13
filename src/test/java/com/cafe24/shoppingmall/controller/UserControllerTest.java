package com.cafe24.shoppingmall.controller;

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
	public void testJoinUserId() throws Exception {

		UserVo userVo = new UserVo();
		userVo.setId("d2o");
		userVo.setName("testUser");
		userVo.setPassword("wjddms95!!");
		userVo.setPasswordQuestion("가장 아끼는 보물은?");
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com"); 
		
		// 이메일 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 아이디 형식입니다.") ));
	} 
	
	@Test
	public void testJoinUserName() throws Exception {
		
		UserVo userVo = new UserVo();
		userVo.setId("leeap1004");
		userVo.setName("d2ㅇ");
		userVo.setPassword("wjddms95!!");
		userVo.setPasswordQuestion("가장 아끼는 보물은?");
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com");
		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/join")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 이름 형식입니다.") ));
	}
	
	@Test
	public void testJoinUserPw() throws Exception {
		
		UserVo userVo = new UserVo("leeap1004", "이정은", "1234", "가장 아끼는 보물은?", 
				"수첩", "01092743036", "leeap1004@gmail.com");
		userVo.setId("leeap1004");
		userVo.setName("이정은");
		userVo.setPassword("1234");
		userVo.setPasswordQuestion("가장 아끼는 보물은?");
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com");
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/join")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 비밀번호 형식입니다.") ));
	}
	 
	@Ignore
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
	
	@Ignore
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
	
	@Ignore
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
















