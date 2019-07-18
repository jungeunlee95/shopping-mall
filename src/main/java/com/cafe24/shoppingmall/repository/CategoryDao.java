package com.cafe24.shoppingmall.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.cafe24.shoppingmall.vo.UserVo;


@Repository
public class CategoryDao{
	
	@Autowired 
	private SqlSession sqlSession;

	public List<CategoryVo> getName(String name) {
		return sqlSession.selectList("category.getName", name);
	}

	public List<CategoryVo> getName(CategoryVo categoryVo) {
		return sqlSession.selectList("category.getName2", categoryVo);
	}

	public int insert(String name) {
		int count = sqlSession.insert("category.insert", name); 
		return count;
	}

	public int insert(CategoryVo categoryVo) {
		int count = sqlSession.insert("category.insertLow", categoryVo); 
		return count;
	}

	public int modify(CategoryVo categoryVo) {
		int count = sqlSession.update("category.modify", categoryVo); 
		return count;
	}

	public int delete(Long no) {
		int count = sqlSession.delete("category.delete", no); 
		return count;
	}


}
