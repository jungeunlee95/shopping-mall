package com.example.shoppingmall.frontend.dto;

// 보내는 용
public class JSONResult2 {
	private String result; // success, fail
	private String message; // if fail, set
	private Object data; // if success, set data 

	public static JSONResult2 success(Object data) {
		return new JSONResult2("success", null, data);
	}

	public static JSONResult2 success(Object data, String value) {
		return new JSONResult2("success", value, data);
	}

	public static JSONResult2 fail(String message) {
		return new JSONResult2("fail", message, null);
	}

	private JSONResult2(String result, String message, Object data) {
		this.result = result;
		this.message = message;
		this.data = data; 
	}

	public JSONResult2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public String getMessage() {
		return message; 
	}

	public Object getData() {
		return data;
	}

	@Override
	public String toString() {
		return "JSONResult [result=" + result + ", message=" + message + ", data=" + data + "]";
	}

}
