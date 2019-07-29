package com.cafe24.shoppingmall.dto;

import javax.validation.constraints.Pattern;

public class RequestDeleteCartDto {
	@Pattern(regexp = "/[^0-9]/g", message = "잘못된 형식입니다.")
	private int no;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "RequestDeleteCartDto [no=" + no + "]";
	}

}
