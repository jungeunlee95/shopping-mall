package com.cafe24.shoppingmall.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.cafe24.shoppingmall.vo.OptionNameVo;
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
		productVo.setIsShow(true);
		productVo.setIsOption(false);
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

	@Ignore
	@Test
	public void addProduct2() throws Exception {
		ProductVo productVo = new ProductVo();
		productVo.setCode("bbb"); 
		productVo.setName("흰색셔츠"); 
		productVo.setPrice(20000);
		productVo.setIsShow(true);
		productVo.setIsOption(true);
		productVo.setShippingFee(3000);
		productVo.setOrderNo(1);
		productVo.setContents("<h1>11아직 안 함</h1>");
		
		// ----------------------- 카테고리 등록-------------------------
		List<CategoryVo> categoryList = new ArrayList<CategoryVo>();
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setNo(3L);
		
		CategoryVo categoryVo2 = new CategoryVo();
		categoryVo2.setNo(4L);
		
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
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(productVo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
	}
	
	// 옵션 등록 ajax
	// 관리자가 옵션 등록하면 등록됨
	@Ignore
	@Test
	public void addOption() throws Exception {

		OptionVo optionVo = new OptionVo();
		optionVo.setName("색상");
		
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
		optionValueVo.setProductNo(30L); // 나중에 가져올거임
		optionValueVo.setOptionNo(1L);
		optionValueVo.setValue("검정색");
		
		OptionValueVo optionValueVo2 = new OptionValueVo();
		optionValueVo2.setProductNo(30L); // 나중에 가져올거임
		optionValueVo2.setOptionNo(1L);
		optionValueVo2.setValue("분홍색");
		
		optionValueVoList.add(optionValueVo);
		optionValueVoList.add(optionValueVo2);
		
		// 이름 검사
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/addOptionValue")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(optionValueVoList)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
		
	}
	
	@Ignore
	@Test
	public void testDeleteProduct() throws Exception {
		Long no = 2L;
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/product/delete/{no}", no)
				.contentType(MediaType.APPLICATION_JSON)); 
		
		resultActions 
		.andExpect(status().isOk()).andDo(print());
		
	}
	
	@Ignore
	@Test
	public void testModifyProduct() throws Exception {
		ProductVo vo = new ProductVo();
		vo.setNo(4L);
		vo.setCode("aaa");
		vo.setName("짱짱바지3");
		vo.setPrice(40000);
		vo.setRegDate("2019-07-22 21:05:22");
		vo.setIsShow(false);
		vo.setIsOption(false);
		vo.setShippingFee(4000);
		vo.setOrderNo(3);
		vo.setContents("ㅋㅋ");

		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/product/modify")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
		
	}
	
	// 옵션(검정/L) 추가
//	@Ignore
	@Test
	public void testAddProductOption() throws Exception {
		OptionNameVo vo = new OptionNameVo();
		vo.setProductNo(35L);
		vo.setProductOptionName("검정/M");
		vo.setAdditionalAmount(0L);
		vo.setUseStock(true);
		vo.setStock(500L);
		
		OptionNameVo vo2 = new OptionNameVo();
		vo2.setProductNo(35L);
		vo2.setProductOptionName("검정/S");
		vo2.setAdditionalAmount(0L);
		vo2.setUseStock(true);
		vo2.setStock(500L);
		
		OptionNameVo vo3 = new OptionNameVo();
		vo3.setProductNo(35L);
		vo3.setProductOptionName("초록/S");
		vo3.setAdditionalAmount(0L);
		vo3.setUseStock(true);
		vo3.setStock(500L);
		
		List<OptionNameVo> list = new ArrayList<OptionNameVo>();
		list.add(vo);
		list.add(vo2);
		list.add(vo3);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product/addProductOption")
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(list)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
		
	}
	
	// 옵션 수정
	@Ignore
	@Test
	public void testModifyOptionValue() throws Exception {
		// ----------------------- 옵션 등록-------------------------
		List<OptionValueVo> optionValueList = new ArrayList<OptionValueVo>();

		OptionValueVo optionValueVo = new OptionValueVo();
		optionValueVo.setOptionNo(1L);
		optionValueVo.setValue("핑꾸");
		// ============= 옵션 값 등록 ===============
		optionValueList.add(optionValueVo);
		
		OptionValueVo optionValueVo2 = new OptionValueVo();
		optionValueVo2.setOptionNo(1L);
		optionValueVo2.setValue("노랭");
		// ============= 옵션 값 등록 ===============
		optionValueList.add(optionValueVo2);
	
		OptionValueVo optionValueVo3 = new OptionValueVo();
		optionValueVo3.setOptionNo(2L);
		optionValueVo3.setValue("XXL");
		// ============= 옵션 값 등록 ===============
		optionValueList.add(optionValueVo3);
		
		OptionValueVo optionValueVo4 = new OptionValueVo();
		optionValueVo4.setOptionNo(2L);
		optionValueVo4.setValue("XL");
		// ============= 옵션 값 등록 ===============
		optionValueList.add(optionValueVo4);
		
		OptionValueVo optionValueVo5 = new OptionValueVo();
		optionValueVo5.setOptionNo(2L);
		optionValueVo5.setValue("L");
		// ============= 옵션 값 등록 ===============
		optionValueList.add(optionValueVo5);
		
		Long productNo = 34L;
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/product/modifyOptionValue/{productNo}", productNo)
						.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(optionValueList)));
		resultActions 
		.andExpect(status().isOk()).andDo(print());  
		
	}
	
}
















