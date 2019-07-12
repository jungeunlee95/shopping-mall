package com.cafe24.shoppingmall.service;

import java.util.List;
import com.cafe24.shoppingmall.vo.ProductVo;

public interface ProductService {

	public List<ProductVo> getProductList(Long categodyNo, String keyword);
	
	public List<ProductVo> getProductList();
	
	public List<ProductVo> getProductList(String userId);
}
