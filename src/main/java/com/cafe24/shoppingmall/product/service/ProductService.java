package com.cafe24.shoppingmall.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.product.repository.ProductDao;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
}
