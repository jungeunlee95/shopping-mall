package com.cafe24.shoppingmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.impl.ProductDaoImpl;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDaoImpl productDao;

	/**
	 * 상품 리스트 가져오기 (카테고리 or 키워드)
	 * @param categodyNo
	 * @param keyword
	 * @return
	 */
	public List<ProductVo> getProductList(Long categodyNo, String keyword) {
		List<ProductVo> list = productDao.getList(categodyNo, keyword);
		return list;
	}

	/**
	 * 메인 상품 리스트
	 * @return
	 */
	public List<ProductVo> getProductList() {
		List<ProductVo> list = productDao.getList();
		return list;
	}

	/** 
	 * 장바구니에 담긴 상품 리스트
	 * @param userId
	 * @return
	 */
	public List<ProductVo> getProductList(String userId) {
		List<ProductVo> list = productDao.getList(userId);
		return list;
	}
}
