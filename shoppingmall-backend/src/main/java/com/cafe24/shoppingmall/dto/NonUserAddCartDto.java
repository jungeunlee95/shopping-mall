package com.cafe24.shoppingmall.dto;

import javax.validation.constraints.NotNull;

public class NonUserAddCartDto {

	@NotNull
	private String nonUserNo;
	
	@NotNull
	private Long productOptionNo;
	
	@NotNull
	private Long quantity;

	public NonUserAddCartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public NonUserAddCartDto(String nonUserNo, Long productOptionNo, Long quantity) {
		super();
		this.nonUserNo = nonUserNo;
		this.productOptionNo = productOptionNo;
		this.quantity = quantity;
	}

	public String getNonUserNo() {
		return nonUserNo;
	}

	public void setNonUserNo(String nonUserNo) {
		this.nonUserNo = nonUserNo;
	}

	public Long getProductOptionNo() {
		return productOptionNo;
	}

	public void setProductOptionNo(Long productOptionNo) {
		this.productOptionNo = productOptionNo;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "NonUserAddCartDto [nonUserNo=" + nonUserNo + ", productOptionNo=" + productOptionNo + ", quantity="
				+ quantity + "]";
	}

}
