package com.cafe24.shoppingmall.dto;

import javax.validation.constraints.NotNull;

public class RequestNonUserAddCartDto {

	@NotNull( message = "오류입니다.")
	private String nonUserNo;
	
	@NotNull( message = "상품옵션 번호를 선택해주세요.")
	private Long productOptionNo;
	
	@NotNull( message = "수량을 입력해주세요.")
	private Long quantity;

	public RequestNonUserAddCartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public RequestNonUserAddCartDto(String nonUserNo, Long productOptionNo, Long quantity) {
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
