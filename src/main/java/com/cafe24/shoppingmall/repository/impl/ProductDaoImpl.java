package com.cafe24.shoppingmall.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.repository.ProductDao;
import com.cafe24.shoppingmall.vo.ProductVo;


@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired 
	private SqlSession sqlSession;
	
	public List<ProductVo> getList(Long categodyNo, String keyword) {
		List<ProductVo> list = new ArrayList<ProductVo>(); 

		ProductVo vo = new ProductVo(1L, "AAA", "AAA", 30000, "2019-07-12", true, true, 2500, 1, "AAA", 1L);
		ProductVo vo2 = new ProductVo(2L, "BBB", "BBB", 1000, "2019-07-13", true, true, 2500, 2, "BBB", 1L);
		list.add(vo);
		list.add(vo2);
		
		return list;
	}

	public List<ProductVo> getList() {
		List<ProductVo> list = new ArrayList<ProductVo>(); 

		ProductVo vo = new ProductVo(1L, "AAA", "AAA", 30000, "2019-07-12", true, true, 2500, 1, "AAA", 1L);
		ProductVo vo2 = new ProductVo(2L, "BBB", "BBB", 1000, "2019-07-13", true, true, 2500, 2, "BBB", 1L);
		list.add(vo);
		list.add(vo2);
		
		return list;
	}

	/** 
	 * 장바구니에 담긴 해당 회원의 상품 List
	 * @param userId
	 * @return
	 */
	public List<ProductVo> getList(String userId) {
		// 해당 회원의 장바구니 리스트 RETURN
		List<ProductVo> list = new ArrayList<ProductVo>(); 

		ProductVo vo = new ProductVo(1L, "AAA", "AAA", 30000, "2019-07-12", true, true, 2500, 1, "AAA", 1L);
		ProductVo vo2 = new ProductVo(2L, "BBB", "BBB", 1000, "2019-07-13", true, true, 2500, 2, "BBB", 1L);
		list.add(vo);
		list.add(vo2);
		
		return list;
	}


}
