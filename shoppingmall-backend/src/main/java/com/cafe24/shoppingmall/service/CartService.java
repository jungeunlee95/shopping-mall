package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
public class CartService{

	@Autowired
	private CartDao cartDao;

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
	public List<CartVo> getCartList(CartVo cartVo) {
		List<CartVo> result = cartDao.getCartList(cartVo);			
		return result;
	}


	public Boolean deleteCart(List<Integer> noList) {
		boolean result = cartDao.delete(noList)==noList.size();			
		return result;
	}




}
