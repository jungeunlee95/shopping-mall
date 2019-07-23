package com.cafe24.shoppingmall.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.ProductVo;


@Repository
public class CartDao{
	
	@Autowired 
	private SqlSession sqlSession;

	/**
	 * 회원 장바구니에 상품추가 
	 * @param userNo
	 * @param optionNo
	 * @param quantity 
	 * @return
	 */
	public boolean add(Long userNo, Long optionNo, Long quantity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userNo", userNo);
		map.put("optionNo", optionNo);
		map.put("quantity", quantity);
		
		return sqlSession.insert("cart.insert",map)==1;
	}

	public boolean modifyOption(String userId, Long cartNo, Long optionNo) {
		boolean result = true;
		return result;
	}

	public boolean modifyQuantity(String userId, Long cartNo, Long quantity) {
		boolean result = true;
		return result;
	}

	public boolean delete(String userId, Long cartNo) {
		boolean result = true;
		return result;
	}


}
