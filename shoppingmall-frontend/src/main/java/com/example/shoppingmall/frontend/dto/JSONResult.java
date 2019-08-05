package com.example.shoppingmall.frontend.dto;

// 받는 용
public class JSONResult<T> {
	private String result; // success, fail
	private String message; // if fail, set
	private T data; // if success, set

	public JSONResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JSONResult(String result, String message, T data) {
		super();
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
