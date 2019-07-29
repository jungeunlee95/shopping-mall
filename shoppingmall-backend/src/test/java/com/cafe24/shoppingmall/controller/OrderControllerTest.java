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
	
	
	// 회원 주문 성공
//	@Ignore
	@Test
	public void testUserOrder() throws Exception {
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
//		OrderDetailVo vo1 = new OrderDetailVo();
//		vo1.setProductOptionNo(11L);
//		vo1.setQuantity(1L);
		
		OrderDetailVo vo2 = new OrderDetailVo();
		vo2.setProductOptionNo(9L);
		vo2.setQuantity(1L);
		
		OrderDetailVo vo3 = new OrderDetailVo();
		vo3.setProductOptionNo(10L);
		vo3.setQuantity(10L);
		
//		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		vo.setProductOptionList(list);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/order/add")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data", is(true))); 
	}
	
	// 비회원주문 성공
	@Ignore
	@Test
	public void testNonUserOrder() throws Exception {
		OrderVo vo = new OrderVo();
		vo.setName("또리");
		vo.setGender("M");
		vo.setPassword("1234");
		vo.setPhoneNumber("010-3333-4444");
		vo.setEmail("bbb@bbb.bbb");
		vo.setAddress("경기 어디 아파트~ 몇동 몇호~");
		vo.setTotalPrice(30000L);
		
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
				.perform(post("/api/nonuser/order/add")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data", is(true))); 
	}
	
	// 재고 부족  test
	@Ignore
	@Test
	public void testCheckStockOrder() throws Exception {
		OrderVo vo = new OrderVo();
		vo.setName("이정인");
		vo.setGender("M");
		vo.setPhoneNumber("010-3333-4444");
		vo.setEmail("bbb@bbb.bbb");
		vo.setAddress("경기 어디 아파트~ 몇동 몇호~");
		vo.setTotalPrice(30000L);
		
		List<OrderDetailVo> list = new ArrayList<OrderDetailVo>();
		OrderDetailVo vo1 = new OrderDetailVo();
		vo1.setProductOptionNo(8L);
		vo1.setQuantity(3L);
		
		OrderDetailVo vo2 = new OrderDetailVo();
		vo2.setProductOptionNo(9L);
		vo2.setQuantity(10L);
		
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
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.result", is("success") ))
		.andExpect(jsonPath("$.data", is(false))); 
	}
	
	@Ignore
	@Test
	public void testGetOrderListByUser() throws Exception {
		OrderVo vo = new OrderVo();
		vo.setNo(2L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/list")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
		
	}
	
//	@Ignore
	@Test
	public void testGetOrderListByNonUser() throws Exception {
		OrderVo vo = new OrderVo();
		vo.setOrderStringNo("20190729-000001");
		vo.setPassword("1234");
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/nonuser/order/list")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());
	}
	
	@Ignore
	@Test
	public void testGetOrderDetaikList() throws Exception {
		Long no = 27L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/detail/{no}", no)
						.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print());
		
	}
}
















