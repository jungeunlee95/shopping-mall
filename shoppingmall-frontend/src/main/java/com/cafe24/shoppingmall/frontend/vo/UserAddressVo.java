package com.cafe24.shoppingmall.frontend.vo;

public class UserAddressVo {

	private Long no;
	private Long userNo;
	private String addressCode;
	private String address;
	private String addressDetail;
	private String addressCheck;

	private String key;

	public UserAddressVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddressVo(Long no, Long userNo, String addressCode, String address, String addressDetail,
			String addressCheck, String key) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.addressCode = addressCode;
		this.address = address;
		this.addressDetail = addressDetail;
		this.addressCheck = addressCheck;
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

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getAddressCheck() {
		return addressCheck;
	}

	public void setAddressCheck(String addressCheck) {
		this.addressCheck = addressCheck;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "UserAddressVo [no=" + no + ", userNo=" + userNo + ", addressCode=" + addressCode + ", address="
				+ address + ", addressDetail=" + addressDetail + ", addressCheck=" + addressCheck + ", key=" + key
				+ "]";
	}

}
