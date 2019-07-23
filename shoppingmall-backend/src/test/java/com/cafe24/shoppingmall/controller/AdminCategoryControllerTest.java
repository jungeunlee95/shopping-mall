package com.cafe24.shoppingmall.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminCategoryControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	

	@Test
	public void getList() throws Exception {

		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/category/list")
				.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print());
		
	}
	
	
	// 상위 카테고리 중복 비교
	@Ignore
	@Test
	public void checkName() throws Exception {
		String cateName = "상의";
		
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/category/checkName?name={name}", cateName)
				.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.data", is(false))); 
		
		cateName = "세일";
		
		resultActions = 
				mockMvc
				.perform(get("/api/admin/category/checkName?name={name}", cateName)
						.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.data", is(true))); 
		
	}
	
	// 하위 카테고리 중복 비교
	@Ignore
	@Test
	public void checkLowName() throws Exception {
		// 현재 카테고리의 depth(상위 or 하위)중 같은 groupNo(같은 상위카테고리를 가진)중에서 중복검사
		/*
			select * 
			from category
			where group_no=1
			and depth=2
			and name = "세일";
		*/
		
		// 상의의 카테고리에 세일! 을 넣고 싶을 때 -> 이미 존재
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setName("세일"); 
		categoryVo.setGroupNo(1L); // 상의의 같은 그룹넘버
		categoryVo.setDepth(2L);   // 상의의 하위 레벨

		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/category/checkLowName")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(categoryVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.data", is(false))); 
		
		// 하의의 카테고리에 세일! 을 넣고 싶을 때 -> 가능!
		categoryVo.setGroupNo(2L); // 하의 그룹넘버
		categoryVo.setDepth(2L);   // 상의의 하위 레벨
		
		
		// 이름 검사
		resultActions = 
				mockMvc
				.perform(get("/api/admin/category/checkLowName")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(categoryVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.data", is(true))); 

	}
	
	// 상위 카테고리 등록
	@Ignore
	@Test
	public void addCategory() throws Exception {
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setName("신발"); 

		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/category/add")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(categoryVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print()); 
	}
	
	// 하위 카테고리 등록
	@Ignore
	@Test
	public void addLowCategory() throws Exception {
		CategoryVo categoryVo = new CategoryVo();
		// 신발 카테고리의 슬리퍼 추가
		categoryVo.setName("슬리퍼"); 
		categoryVo.setDepth(1L);   // 해당 카테고리 깊이 + 1
		categoryVo.setGroupNo(4L); // 같은 그룹넘버

		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/category/addLow")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(categoryVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print()); 
	}
	
	@Ignore
	@Test
	public void modifyCategory() throws Exception {
		CategoryVo categoryVo = new CategoryVo();
		// 신발 카테고리의 슬리퍼 추가
		categoryVo.setName("상의!"); 
		categoryVo.setNo(1L);  

		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/category/modify")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(categoryVo)));
		
		resultActions 
		.andExpect(status().isOk()).andDo(print()); 
	}
	
	@Ignore
	@Test
	public void deleteCategory() throws Exception {
		Long no = 12L;   
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/category/delete?no={no}", no)
				.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print()); 
	}
	
}
















