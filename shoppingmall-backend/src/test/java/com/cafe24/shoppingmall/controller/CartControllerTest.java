package com.cafe24.shoppingmall.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.vo.CartVo;
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
		vo.setQuantity(105L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/nonuser/cart/add")
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
		vo.setQuantity(200L);
		
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
	
	@Ignore
	@Test
	public void testNonUserGetList() throws Exception {
		CartVo vo = new CartVo();
		vo.setNonUserNo("AA1234BB");
		
		ResultActions resultActions =  
				mockMvc
				.perform(get("/api/nonuser/cart/getList")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	@Ignore
	@Test
	public void getOptionList() throws Exception {
		String no = "8";
		
		ResultActions resultActions =
				mockMvc
				.perform(get("/api/nonuser/cart/getOptionList")
				.param("no", no)	
				.contentType(MediaType.APPLICATION_JSON));
		

		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	

	@Ignore
	@Test
	public void testDeleteCart() throws Exception {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(18);
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/cart/delete")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(list)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	
	
	
}
















