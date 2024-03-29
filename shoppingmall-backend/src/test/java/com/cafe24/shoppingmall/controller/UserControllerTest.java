package com.cafe24.shoppingmall.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hibernate.validator.internal.util.privilegedactions.GetResources;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.config.WebConfig;
import com.cafe24.shoppingmall.vo.UserAddressVo;
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Ignore
	@Test
	@Rollback(false)
	public void testJoinSuccess() throws Exception {
		 
		UserVo userVo = new UserVo();
		userVo.setId("aleeap1005");
		userVo.setName("이정응"); 
		userVo.setGender("F");
		userVo.setPassword("Gkdlfn123");
		userVo.setPasswordQuestion(1);
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com");
		userVo.setGender("F");
		
		// 이름 검사 
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/nonuser/join")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	@Ignore
	@Test
	public void testJoinUserId() throws Exception {

		UserVo userVo = new UserVo();
		userVo.setId("d2o");
		userVo.setName("testUser"); 
		userVo.setGender("F");
		userVo.setPassword("Gkdlfn123");
		userVo.setPasswordQuestion(1);
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036"); 
		userVo.setEmail("leeap1004@gmail.com"); 
		 
		// 이메일 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/nonuser/join")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 아이디 형식입니다.") ));
	} 
	
	@Ignore
	@Test
	public void testJoinUserName() throws Exception {
		
		UserVo userVo = new UserVo();
		userVo.setId("leeap1004");
		userVo.setName("d2ㅇ");
		userVo.setGender("F");
		userVo.setPassword("Gkdlfn123");
		userVo.setPasswordQuestion(1);
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com");
		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/nonuser/join")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 이름 형식입니다.") ));
	}
	
	@Ignore
	@Test
	public void testJoinUserPw() throws Exception {
		
		UserVo userVo = new UserVo();
		userVo.setId("leeap1004");
		userVo.setName("이정은"); 
		userVo.setGender("F");
		userVo.setPassword("ddddddddd");
		userVo.setPasswordQuestion(1);
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com");
		// 이름 검사 
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/nonuser/join")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 비밀번호 형식입니다.") ));
	}
	
	@Ignore
	@Test
	public void testJoinUserEmail() throws Exception {
		
		UserVo userVo = new UserVo();
		userVo.setId("leeap1004");
		userVo.setName("이정은"); 
		userVo.setGender("F");
		userVo.setPassword("Gkdlfn123");
		userVo.setPasswordQuestion(1);
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("aaa");
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/nonuser/join")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 이메일 형식입니다.") ));
	}
	
	@Ignore
	@Test
	public void testJoinUserGender() throws Exception {
		
		UserVo userVo = new UserVo();
		userVo.setId("leeap1004");
		userVo.setName("이정은"); 
		userVo.setGender("ded");
		userVo.setPassword("Gkdlfn123");
		userVo.setPasswordQuestion(1);
		userVo.setPasswordAnswer("수첩");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1004@gmail.com");
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/nonuser/join")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.message", is("잘못된 성별 형식입니다.") ));
	}

	
	@Ignore
	@Test
	public void testCheckId() throws Exception {

		String id = "userId";
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/nonuser/checkId?id={id}", id)
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data", is(true))); 
		
		id = "leeap1003";
		
		resultActions = 
				mockMvc
				.perform(get("/api/nonuser/checkId?id={id}", id)
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
		
		// 로그인 실패
		UserVo userVo = new UserVo();
		userVo.setId("d");
		userVo.setPassword("userPW123");
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/nonuser/login")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		
		resultActions 
		.andExpect(status().isBadRequest()).andDo(print())
		.andExpect(jsonPath("$.result", is("fail") ))
		.andExpect(jsonPath("$.message", is("잘못된 아이디 형식입니다."))); 
		
		// 로그인 실패
		userVo.setId("leeap1005");
		userVo.setPassword("userPW123");
		
		resultActions = 
				mockMvc
				.perform(get("/api/nonuser/login")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));

		resultActions  
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("fail") ))
		.andExpect(jsonPath("$.message", is("아이디나 비밀번호 값이 잘못 되었습니다."))); 
		System.out.println("==========================================================");
		
		// 로그인 성공
		userVo = new UserVo();
		userVo.setId("leeap1002");
		userVo.setPassword("Wjddms1234");
		
		resultActions = 
				mockMvc
				.perform(get("/api/nonuser/login")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));

		resultActions  
		.andExpect(status().isOk()).andDo(print())		
		.andExpect(jsonPath("$.result", is("success") )); 

	}
	
	@Ignore
	@Test
	public void findId() throws Exception {

		String email = "leeap1003@gmail.com";
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/nonuser/findId?email={email}", email)
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data", is("leeap1003"))); 
	}

	@Ignore
	@Test
	public void userList() throws Exception {
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/user/userList")
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print()); 
	}
	
	@Ignore
	@Test
	@Rollback(false)
	public void modifyUser() throws Exception {
		UserVo userVo = new UserVo();
		userVo.setNo(7L);
		userVo.setId("leeap1000");
		userVo.setName("이정은"); 
		userVo.setPassword("Wjddms1234");
		userVo.setPasswordQuestion(22);
		userVo.setPasswordAnswer("바보~");
		userVo.setPhoneNumber("010-9274-3036");
		userVo.setEmail("leeap1003@gmail.com");
		userVo.setBirthDate("1992-07-08");
		userVo.setGender("M");
		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/user/modify")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	@Ignore
	@Test
	@Rollback(false)
	public void deleteUser() throws Exception {
		
		Long no = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/user/deleteUser?no={no}", no)
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print()); 
	}
	
	@Ignore
	@Test
	public void testAddUserAddress() throws Exception {
		 
		UserAddressVo vo = new UserAddressVo();
		vo.setUserNo(3L);
		vo.setAddressCode("16929");
		vo.setAddress("서울시 강남구 어디건물");
		vo.setAddressDetail("몇동 몇호");
		vo.setAddressCheck("회사");
		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/user/addAddress")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	// 주소지 리스트 가져오기
	@Ignore
	@Test
	public void getUserAddressList() throws Exception {
		String userNo = "2";
		
		ResultActions resultActions =
				mockMvc
				.perform(get("/api/user/getAddressList")
				.param("userNo", userNo)	
				.contentType(MediaType.APPLICATION_JSON));
		

		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	// 주소지 가져오기
	@Ignore
	@Test
	public void getUserAddress() throws Exception {
		String addressNo = "1";
		
		ResultActions resultActions =
				mockMvc
				.perform(get("/api/user/getAddress")
						.param("addressNo", addressNo)	
						.contentType(MediaType.APPLICATION_JSON));
		
		
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	// 주소지 삭제
	@Ignore
	@Test
	public void deleteAddress() throws Exception {
		String addressNo = "1";
		
		ResultActions resultActions =
				mockMvc
				.perform(delete("/api/user/deleteAddress")
						.param("addressNo", addressNo)	
						.contentType(MediaType.APPLICATION_JSON));
		
		
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
}
















