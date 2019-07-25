package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.CartVo;


@Repository
public class CartDao{
	
	@Autowired 
	private SqlSession sqlSession;

	//장바구니에 상품추가 
	public int addCart(CartVo cartVo) {
		return sqlSession.insert("cart.insertNew",cartVo);
	}
	
	//장바구니에 기존 상품추가 
	public int plusQuantity(CartVo cartVo) {
		return sqlSession.insert("cart.plusQuantity",cartVo);
	}
	
	//장바구니 상품 체크
	public int checkCart(CartVo cartVo) {
		return sqlSession.selectOne("cart.count",cartVo);
	}

	// 장바구니 리스트 가져오기
	public List<CartVo> getCartList(CartVo cartVo) {
		return sqlSession.selectList("cart.getList", cartVo);
	}

	public int delete(List<Integer> noList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noList", noList);
		return sqlSession.delete("cart.delete", map);
	}
	
	
	

}
