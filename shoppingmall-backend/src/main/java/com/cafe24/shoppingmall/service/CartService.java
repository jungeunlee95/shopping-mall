package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.shoppingmall.dto.RequestNonUserAddCartDto;
import com.cafe24.shoppingmall.dto.RequestDeleteCartDto;
import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.vo.CartVo;

@Transactional(rollbackFor = Exception.class)
@Service
public class CartService{

	@Autowired
	private CartDao cartDao;

	// ========================== 회원 =============================
	// 장바구니 상품 추가
	public boolean addCart(CartVo cartVo) {
		boolean result = false;
		if(cartDao.checkCart(cartVo)==0) {
			result = cartDao.addCart(cartVo)==1;			
		}else {
			result = cartDao.plusQuantity(cartVo)==1;			
		}
		return result;
	}
	
	// 장바구니 목록 가져오기 
	public List<CartVo> getCartList(Long userNo) {
		List<CartVo> result = cartDao.getCartList(userNo);			
		return result;
	}
	// ===========================================================
	
	
	// ========================== 비회원 =============================
	// 비회원 장바구니 상품 추가
	public boolean addCart(RequestNonUserAddCartDto nonUserAddCartDto) {
		boolean result = false;
		if(cartDao.checkCart(nonUserAddCartDto)==0) {
			result = cartDao.addCart(nonUserAddCartDto)==1;			
		}else {
			result = cartDao.plusQuantity(nonUserAddCartDto)==1;			
		}
		return result;
	}
	
	
	// 장바구니 목록 가져오기 
	public List<CartVo> getCartList(RequestNonUserAddCartDto nonUserAddCartDto) {
		List<CartVo> result = cartDao.getCartList(nonUserAddCartDto);			
		return result;
	}
	// ===========================================================

	public Boolean deleteCart(List<RequestDeleteCartDto> noList) {
		boolean result = cartDao.delete(noList)==noList.size();			
		return result;
	}

	public Boolean deleteCart(Long no) {
		boolean result = cartDao.delete(no)==1;			
		return result;
	}




}
