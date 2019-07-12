package com.cafe24.shoppingmall.repository;

import java.util.List;

import com.cafe24.shoppingmall.vo.ProductVo;

public interface ProductDao {
	
	public List<ProductVo> getList(Long categodyNo, String keyword);

	public List<ProductVo> getList();

	public List<ProductVo> getList(String userId);


}
