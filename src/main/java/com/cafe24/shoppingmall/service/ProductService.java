package com.cafe24.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.ProductDao;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public List<ProductVo> getProductList(Long categodyNo, String keyword) {
		List<ProductVo> list = productDao.getList(categodyNo, keyword);
		return list;
	}
}
