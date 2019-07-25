package com.cafe24.shoppingmall.vo;

public class OrderVo {
	private String key;

	private Long no;
	private Long userNo;
	private Long orderNo;
	private String name;
	private String gender;
	private String password;
	private String phoneNumber;
	private String email;
	private String address;
	private Long totalPrice;
	private String regDate;
	private String message;

	public OrderVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderVo(String key, Long no, Long userNo, Long orderNo, String name, String gender, String password,
			String phoneNumber, String email, String address, Long totalPrice, String regDate, String message) {
		super();
		this.key = key;
		this.no = no;
		this.userNo = userNo;
		this.orderNo = orderNo;
		this.name = name;
		this.gender = gender;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.totalPrice = totalPrice;
		this.regDate = regDate;
		this.message = message;
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

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
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

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OrderVo [key=" + key + ", no=" + no + ", userNo=" + userNo + ", orderNo=" + orderNo + ", name=" + name
				+ ", gender=" + gender + ", password=" + password + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", address=" + address + ", totalPrice=" + totalPrice + ", regDate=" + regDate + ", message="
				+ message + "]";
	}

}
