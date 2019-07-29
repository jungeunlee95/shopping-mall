package com.cafe24.shoppingmall.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.cafe24.shoppingmall.vo.OrderDetailVo;

public class RequestNonUserOrderDto {

	private String key;
	private Long no;
	private String nonUserNo;
	private String name;
	private String gender;
	private String password;
	private String phoneNumber;
	private String email;
	private String address;
	private String message;
	private Long totalPrice;
	private List<OrderDetailVo> productOptionList;

	public RequestNonUserOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getNonUserNo() {
		return nonUserNo;
	}

	public void setNonUserNo(String nonUserNo) {
		this.nonUserNo = nonUserNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderDetailVo> getProductOptionList() {
		return productOptionList;
	}

	public void setProductOptionList(List<OrderDetailVo> productOptionList) {
		this.productOptionList = productOptionList;
	}

	@Override
	public String toString() {
		return "RequestNonUserOrderDto [key=" + key + ", no=" + no + ", nonUserNo=" + nonUserNo + ", name=" + name
				+ ", gender=" + gender + ", password=" + password + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", address=" + address + ", message=" + message + ", totalPrice=" + totalPrice
				+ ", productOptionList=" + productOptionList + "]";
	}

}
