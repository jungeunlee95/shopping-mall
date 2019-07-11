package com.cafe24.shoppingmall.product.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDao {
	
	@Autowired 
	private SqlSession sqlSession;

	public void insert() {
		
	}


}
