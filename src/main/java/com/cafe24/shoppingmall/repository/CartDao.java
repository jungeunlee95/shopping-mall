package com.cafe24.shoppingmall.repository;

public interface CartDao {
	
	public boolean add(String userId, Long optionNo);
	
	public boolean modifyOption(String userId, Long cartNo, Long optionNo);
	
	public boolean modifyQuantity(String userId, Long cartNo, Long quantity) ;

	public boolean delete(String userId, Long cartNo);


}
