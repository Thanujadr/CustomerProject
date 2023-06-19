package com.student.app.response;

import org.springframework.http.HttpStatus;

public class ResponseStructure<T> {

	private T data;//T is holding customer object
	private HttpStatus httpstatus;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
	@Override
	public String toString() {
		return "ResponseStructure [data=" + data + ", httpstatus=" + httpstatus + "]";
	}
	
	
}
