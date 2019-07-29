package com.cafe24.shoppingmall.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.cafe24.shoppingmall.vo.OrderDetailVo;

public class RequestNonUserOrderListDto {

	private String key;
	private Long no;
	private String orderStringNo;
	private String password;

	public RequestNonUserOrderListDto() {
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

	public String getOrderStringNo() {
		return orderStringNo;
	}

	public void setOrderStringNo(String orderStringNo) {
		this.orderStringNo = orderStringNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RequestNonUserOrderListDto [key=" + key + ", no=" + no + ", orderStringNo=" + orderStringNo
				+ ", password=" + password + "]";
	}

}
