package com.cafe24.shoppingmall.frontend.dto;

import java.util.List;

public class OrderDto {

	private String key;
	private String orderStringNo;
	private Long no;
	private Long orderUserNo;

	// 주문자 정보
	private Long userNo;
	private String userName;

	private String userAddress;
	private String postcode;
	private String roadAddress;
	private String jibunAddress;
	private String extraAddress;
	private String detailAddress;

	private String userPhoneNumber;
	private String txtMobile1;
	private String txtMobile2;
	private String txtMobile3;

	private String userEmail;
	private String shippingMessage;
	private String regDate;

	// 배송받을 사람 정보
//	private Long receiveUserName;
//	private String receiveUserAddress;
//	private String receiveUserPhoneNumber;
//  private String message;

	// 상품 정보
	private List<OrderProductDto> orderProductDto;
	private Long totalPrice;

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
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

	public Long getOrderUserNo() {
		return orderUserNo;
	}

	public void setOrderUserNo(Long orderUserNo) {
		this.orderUserNo = orderUserNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return postcode + " " + roadAddress + " " + jibunAddress + " " + extraAddress + " " + detailAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getJibunAddress() {
		return jibunAddress;
	}

	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}

	public String getExtraAddress() {
		return extraAddress;
	}

	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getUserPhoneNumber() {
		return txtMobile1 + "-" + txtMobile2 + "-" + txtMobile3;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getTxtMobile1() {
		return txtMobile1;
	}

	public void setTxtMobile1(String txtMobile1) {
		this.txtMobile1 = txtMobile1;
	}

	public String getTxtMobile2() {
		return txtMobile2;
	}

	public void setTxtMobile2(String txtMobile2) {
		this.txtMobile2 = txtMobile2;
	}

	public String getTxtMobile3() {
		return txtMobile3;
	}

	public void setTxtMobile3(String txtMobile3) {
		this.txtMobile3 = txtMobile3;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getShippingMessage() {
		return shippingMessage;
	}

	public void setShippingMessage(String shippingMessage) {
		this.shippingMessage = shippingMessage;
	}

	public List<OrderProductDto> getOrderProductDto() {
		return orderProductDto;
	}

	public void setOrderProductDto(List<OrderProductDto> orderProductDto) {
		this.orderProductDto = orderProductDto;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStringNo() {
		return orderStringNo;
	}

	public void setOrderStringNo(String orderStringNo) {
		this.orderStringNo = orderStringNo;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public OrderDto(String key, String orderStringNo, Long no, Long orderUserNo, Long userNo, String userName,
			String userAddress, String postcode, String roadAddress, String jibunAddress, String extraAddress,
			String detailAddress, String userPhoneNumber, String txtMobile1, String txtMobile2, String txtMobile3,
			String userEmail, String shippingMessage, String regDate, List<OrderProductDto> orderProductDto,
			Long totalPrice) {
		super();
		this.key = key;
		this.orderStringNo = orderStringNo;
		this.no = no;
		this.orderUserNo = orderUserNo;
		this.userNo = userNo;
		this.userName = userName;
		this.userAddress = userAddress;
		this.postcode = postcode;
		this.roadAddress = roadAddress;
		this.jibunAddress = jibunAddress;
		this.extraAddress = extraAddress;
		this.detailAddress = detailAddress;
		this.userPhoneNumber = userPhoneNumber;
		this.txtMobile1 = txtMobile1;
		this.txtMobile2 = txtMobile2;
		this.txtMobile3 = txtMobile3;
		this.userEmail = userEmail;
		this.shippingMessage = shippingMessage;
		this.regDate = regDate;
		this.orderProductDto = orderProductDto;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderDto [key=" + key + ", orderStringNo=" + orderStringNo + ", no=" + no + ", orderUserNo="
				+ orderUserNo + ", userNo=" + userNo + ", userName=" + userName + ", userAddress=" + userAddress
				+ ", postcode=" + postcode + ", roadAddress=" + roadAddress + ", jibunAddress=" + jibunAddress
				+ ", extraAddress=" + extraAddress + ", detailAddress=" + detailAddress + ", userPhoneNumber="
				+ userPhoneNumber + ", txtMobile1=" + txtMobile1 + ", txtMobile2=" + txtMobile2 + ", txtMobile3="
				+ txtMobile3 + ", userEmail=" + userEmail + ", shippingMessage=" + shippingMessage + ", regDate="
				+ regDate + ", orderProductDto=" + orderProductDto + ", totalPrice=" + totalPrice + "]";
	}

}
