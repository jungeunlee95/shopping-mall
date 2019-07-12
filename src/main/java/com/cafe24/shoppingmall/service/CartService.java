package com.cafe24.shoppingmall.service;

public interface CartService {

	public boolean addCart(String userId, Long optionNo);

	public boolean modifyCartOption(String userId, Long cartNo, Long optionNo);
	
	public boolean modifyCartQuantity(String userId, Long cartNo, Long quantity);
	
	public boolean deleteCart(String userId, Long cartNo);

}
