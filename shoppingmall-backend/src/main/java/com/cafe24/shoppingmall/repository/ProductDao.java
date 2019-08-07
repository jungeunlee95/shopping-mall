package com.cafe24.shoppingmall.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.OptionNameVo;
import com.cafe24.shoppingmall.vo.OptionValueVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import com.cafe24.shoppingmall.vo.ProductVo;


@Repository
public class ProductDao{
	
	@Autowired 
	private SqlSession sqlSession;
	
	public int addProduct(ProductVo productVo) {
		int result = sqlSession.insert("product.addProduct", productVo);

		return result;
	}
	
	public int addCategoryAndProduct(Long no, List<CategoryVo> categoryList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productNo", no);
		map.put("categoryList", categoryList); 
		int result = sqlSession.insert("product.addCategoryAndProduct", map);
		return result;
	}
	
	
	public List<ProductVo> getList(Long categoryNo, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryNo", keyword);
		map.put("keyword", keyword);
		return sqlSession.selectList("product.getList2", map);
	}

	public List<ProductVo> getList() {
		return sqlSession.selectList("product.getList");
	}

	/** 
	 * 장바구니에 담긴 해당 회원의 상품 List
	 * @param userId
	 * @return
	 */
	public List<ProductVo> getList(String userId) {
		// 해당 회원의 장바구니 리스트 RETURN
		List<ProductVo> list = new ArrayList<ProductVo>(); 
		
		return list;
	}

	public List<OptionVo> getOption(String name) {
		List<OptionVo> list = sqlSession.selectList("product.getOption", name);
		return list;
	} 

	public Boolean addOption(OptionVo optionVo) {
		int result = sqlSession.insert("product.addOption", optionVo);
		return result == 1;
		
	}

	public int addOptionValue(Long productNo, List<OptionValueVo> optionValueList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productNo", productNo);
		map.put("optionValueList", optionValueList);
		
		return sqlSession.insert("product.addOptionValue", map);
	}

	public ProductVo getProductDetail(Long productNo) {
		ProductVo vo = sqlSession.selectOne("product.getProductDetail", productNo);
		return vo;
	}

	public int delete(Long no) {
		return sqlSession.delete("product.delete", no);
	}

	public Boolean modify(ProductVo productVo) {
		Boolean result = sqlSession.update("product.modify", productVo)==1;
		return result;
	}

	public int addProductOption(List<OptionNameVo> optionNameVoList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("optionNameVoList", optionNameVoList);
		int result = sqlSession.insert("product.addOptionNameVoList", map);
		return result;
	}

	public List<OptionValueVo> getLowOption(Long productNo) {
		List<OptionValueVo> list = sqlSession.selectList("product.getLowOption", productNo);
		return list;
	}

	public int deleteOptionValue(Long productNo) {
		int result = sqlSession.delete("product.deleteOptionValue", productNo);
		return result;
	}

	public int deleteOption(Long productNo) {
		int result = sqlSession.delete("product.deleteOption", productNo);
		return result;
	}

	public List<OptionNameVo> getOptionList(Long no) {
		List<OptionNameVo> list = sqlSession.selectList("product.getOptionList", no);
		return list;
	}

	public int addMainImage(ProductVo productVo) {
		int result = sqlSession.insert("product.mainImage", productVo);
		return result;
	}


}
