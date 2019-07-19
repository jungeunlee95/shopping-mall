package com.cafe24.shoppingmall.controller;

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

import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.OptionValueVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminProductControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	

	// 옵션 X 상품 등록
	@Ignore
	@Test
	public void addProduct() throws Exception {
		ProductVo productVo = new ProductVo();
		productVo.setCode("aaa"); 
		productVo.setName("곰돌이티셔츠2"); 
		productVo.setPrice(20000);
		productVo.setShow(true);
		productVo.setOption(false);
		productVo.setShippingFee(2500);
		productVo.setOrderNo(1);
		productVo.setContents("<h1>아직 안 함</h1>");
		
		List<CategoryVo> categoryList = new ArrayList<CategoryVo>();
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setNo(4L);
		
		CategoryVo categoryVo2 = new CategoryVo();
		categoryVo2.setNo(8L);
		categoryList.add(categoryVo);
		categoryList.add(categoryVo2);
		
		productVo.setCategoryList(categoryList);
		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product/add")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(productVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
	}
	
	// 옵션 O 상품 등록
	@Test
	public void addProduct2() throws Exception {
		ProductVo productVo = new ProductVo();
		productVo.setCode("aaa"); 
		productVo.setName("치마바지"); 
		productVo.setPrice(20000);
		productVo.setShow(true);
		productVo.setOption(true);
		productVo.setShippingFee(3000);
		productVo.setOrderNo(1);
		productVo.setContents("<h1>11아직 안 함</h1>");
		
		// ----------------------- 카테고리 등록-------------------------
		List<CategoryVo> categoryList = new ArrayList<CategoryVo>();
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setNo(7L);
		
		CategoryVo categoryVo2 = new CategoryVo();
		categoryVo2.setNo(8L);
		categoryList.add(categoryVo);
		categoryList.add(categoryVo2);
		
		productVo.setCategoryList(categoryList);
		// ----------------------------------------------------------
		
		// ----------------------- 옵션 등록-------------------------
		List<OptionValueVo> optionValueList = new ArrayList<OptionValueVo>();
		// ============= 옵션 값 등록 ===============
		OptionValueVo optionValueVo = new OptionValueVo();
		optionValueVo.setOptionNo(1L);
		optionValueVo.setValue("검정색");
		optionValueList.add(optionValueVo);
		
		OptionValueVo optionValueVo2 = new OptionValueVo();
		optionValueVo2.setOptionNo(1L);
		optionValueVo2.setValue("분홍색");
		optionValueList.add(optionValueVo2);
	
		OptionValueVo optionValueVo3 = new OptionValueVo();
		optionValueVo3.setOptionNo(2L);
		optionValueVo3.setValue("L");
		optionValueList.add(optionValueVo3);
		
		OptionValueVo optionValueVo4 = new OptionValueVo();
		optionValueVo4.setOptionNo(2L);
		optionValueVo4.setValue("M");
		optionValueList.add(optionValueVo4);
		
		OptionValueVo optionValueVo5 = new OptionValueVo();
		optionValueVo5.setOptionNo(2L);
		optionValueVo5.setValue("S");
		optionValueList.add(optionValueVo5);
		// ============= 옵션 값 등록 ===============
		productVo.setOptionValueList(optionValueList);
		// ----------------------------------------------------------
		
		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product/add")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(productVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
	}
	
	// 옵션 등록 ajax
	// 관리자가 옵션 등록하면 등록됨
	@Ignore
	@Test
	public void addOption() throws Exception {

		OptionVo optionVo = new OptionVo();
		optionVo.setName("사이즈");
		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product/addOption")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(optionVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
		
	}
	
	// 옵션 값 등록(상품 등록 후)
	// 관리자가 상품 등록하고 하위 옵션 넣을때
	@Ignore
	@Test
	public void addOptionValue() throws Exception {
		List<OptionValueVo> optionValueVoList = new ArrayList<OptionValueVo>();
		
		OptionValueVo optionValueVo = new OptionValueVo();
		optionValueVo.setProductNo(1L); // 나중에 가져올거임
		optionValueVo.setOptionNo(1L);
		optionValueVo.setValue("검정색");
		
		OptionValueVo optionValueVo2 = new OptionValueVo();
		optionValueVo2.setProductNo(1L); // 나중에 가져올거임
		optionValueVo2.setOptionNo(1L);
		optionValueVo2.setValue("분홍색");
		
		optionValueVoList.add(optionValueVo);
		optionValueVoList.add(optionValueVo2);
		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product/addOptionValue")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(optionValueVoList)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
		
	}
	
	
}
















