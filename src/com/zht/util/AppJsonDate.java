package com.zht.util;

public class AppJsonDate {
	public Object data;
	public String message;
	public int code = 1;

	public AppJsonDate(Object data, String message) {
		super();
		this.data = data;
		this.message = message;
	}

	public AppJsonDate(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
