package com.cafe24.shoppingmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.dto.RequestNonUserAddCartDto;
import com.cafe24.shoppingmall.dto.RequestDeleteCartDto;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.OrderDetailVo;


@Repository
public class CartDao{
	
	@Autowired 
	private SqlSession sqlSession;

	// ========================== 회원 =============================
	//장바구니에 상품추가 
	public int addCart(CartVo cartVo) {
		return sqlSession.insert("cart.insertUser",cartVo);
	}
	
	//장바구니에 기존 상품추가 
	public int plusQuantity(CartVo cartVo) {
		return sqlSession.insert("cart.plusQuantityUser",cartVo);
	}
	
	//장바구니 상품 체크
	public int checkCart(CartVo cartVo) {
		return sqlSession.selectOne("cart.countUser",cartVo);
	}
	
	// 장바구니 리스트 가져오기
	public List<CartVo> getCartList(CartVo cartVo) {
		return sqlSession.selectList("cart.getListUser", cartVo);
	}
	
	public int deleteProduct(Long userNo, List<OrderDetailVo> productOptionList) {
		System.out.println("=======================================");
		System.out.println(userNo + " : " + productOptionList);
		System.out.println("=======================================");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userNo", userNo);
		map.put("productOptionList", productOptionList);
		return sqlSession.delete("cart.deleteOrderedProduct", map);
	}
	// =============================================================
	
	// ========================== 비회원 =============================
	//장바구니에 상품추가 
	public int addCart(RequestNonUserAddCartDto nonUserAddCartDto) {
		return sqlSession.insert("cart.insertNonUser",nonUserAddCartDto);
	}
	
	//장바구니에 기존 상품추가 
	public int plusQuantity(RequestNonUserAddCartDto nonUserAddCartDto) {
		return sqlSession.insert("cart.plusQuantityNonUser",nonUserAddCartDto);
	} 
	
	//장바구니 상품 체크
	public int checkCart(RequestNonUserAddCartDto nonUserAddCartDto) {
		return sqlSession.selectOne("cart.countNonUser", nonUserAddCartDto);
	}
	
	// 장바구니 리스트 가져오기
	public List<CartVo> getCartList(RequestNonUserAddCartDto nonUserAddCartDto) {
		return sqlSession.selectList("cart.getListNonUser", nonUserAddCartDto);
	}	
	// =============================================================

	
	// 장바구니 상품 삭제
	public int delete(List<RequestDeleteCartDto> noList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("noList", noList);
		return sqlSession.delete("cart.delete", map);
	}

}
