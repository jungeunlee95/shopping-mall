package com.cafe24.shoppingmall.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.user.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

}
