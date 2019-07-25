package com.cafe24.shoppingmall.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.OrderDetailVo;
import com.cafe24.shoppingmall.vo.OrderVo;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.cafe24.shoppingmall.vo.UserAddressVo;
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void addProduct() throws Exception {
		OrderVo vo = new OrderVo();
		vo.setUserNo(2L);
		vo.setName("이정은");
		vo.setGender("F");
		vo.setPhoneNumber("010-1111-2222");
		vo.setEmail("aaa@aaa.aaa");
		vo.setAddress("서울 어디 아파트~ 몇동 몇호~");
		vo.setTotalPrice(50000L);
		vo.setMessage("경비실에 맡겨주세요");
		
		List<OrderDetailVo> list = new ArrayList<OrderDetailVo>();
		OrderDetailVo vo1 = new OrderDetailVo();
		vo1.setProductOptionNo(8L);
		vo1.setQuantity(3L);
		
		OrderDetailVo vo2 = new OrderDetailVo();
		vo2.setProductOptionNo(9L);
		vo2.setQuantity(1L);
		
		OrderDetailVo vo3 = new OrderDetailVo();
		vo3.setProductOptionNo(10L);
		vo3.setQuantity(10L);
		
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		vo.setProductOptionList(list);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/order/add")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
	}
	
}
















