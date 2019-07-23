package com.cafe24.shoppingmall.repository;

import java.util.ArrayList;
import java.util.List;

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
	 * @param userId
	 * @param optionNo
	 * @return
	 */
	public boolean add(String userId, Long optionNo) {
		boolean result = true;
		return result;
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
