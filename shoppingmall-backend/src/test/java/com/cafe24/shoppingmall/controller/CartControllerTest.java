package com.cafe24.shoppingmall.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.config.WebConfig;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Ignore
	@Test
	public void testNonUserAddCart() throws Exception {
		CartVo vo = new CartVo();
		vo.setNonUserNo("AA1234BB");
		vo.setProductOptionNo(10L);
		vo.setQuantity(5L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/cart/add")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	@Ignore
	@Test
	public void testUserAddCart() throws Exception {
		CartVo vo = new CartVo();
		vo.setUserNo(2L);
		vo.setProductOptionNo(10L);
		vo.setQuantity(500L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/cart/add")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	@Ignore
	@Test
	public void testUserGetList() throws Exception {
		CartVo vo = new CartVo();
		vo.setUserNo(2L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/cart/getList")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testNonUserGetList() throws Exception {
		CartVo vo = new CartVo();
		vo.setNonUserNo("AA1234BB");
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/cart/getList")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	
	
	
	
	@Ignore
	@Test
	public void testGetCart() throws Exception {
		String userId = "leeap1004";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/cart/{userId}", userId)
				.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print());
		
	}
	
	@Ignore
	@Test
	public void testModifyCartOption() throws Exception {
		// leeap1004회원의 장바구니 2번의 옵션을 1로 변경
		String userId = "leeap1004";
		String cartNo = "2";
		String optionNo = "1";
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/cart/modify/{userId}/{cartNo}", userId, cartNo)
				.param("optionNo", optionNo)
				.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print());
		
	}
	
	@Ignore
	@Test
	public void testModifyCartQuantity() throws Exception {
		// leeap1004회원의 장바구니 2번의 옵션의 수량을 3으로 변경
		String userId = "leeap1004";
		String cartNo = "2";
		String quantity = "3";
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/cart/modify/{userId}/{cartNo}", userId, cartNo)
						.param("quantity", quantity)
						.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print());
		
	}
	
	@Ignore
	@Test
	public void testDeleteCart() throws Exception {
		// leeap1004회원의 장바구니 2L번의 옵션을 삭제
		String userId = "leeap1004";
		String cartNo = "2";
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/cart/delete/{userId}/{cartNo}", userId, cartNo)
				.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print());
		
	}
}
















