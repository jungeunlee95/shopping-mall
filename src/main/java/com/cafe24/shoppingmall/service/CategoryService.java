package com.cafe24.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.CategoryDao;
import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.UserVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public Boolean checkName(String name) {
		Boolean exist = categoryDao.getName(name).size()==0; 
		return exist;
	}

	public Boolean checkName(CategoryVo categoryVo) {
		Boolean exist = categoryDao.getName(categoryVo).size()==0; 
		return exist;
	}

	public Boolean addCategory(String name) {
		return categoryDao.insert(name)==1;
	}

	public Boolean addCategory(CategoryVo categoryVo) {
		return categoryDao.insert(categoryVo)==1;
	}

	public Boolean modifyCategory(CategoryVo categoryVo) {
		return categoryDao.modify(categoryVo)==1;
	}

	public Boolean deleteCategory(Long no) {
		return categoryDao.delete(no)==1;
	}
}
