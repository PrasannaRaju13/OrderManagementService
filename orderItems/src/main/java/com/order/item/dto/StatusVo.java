package com.order.item.dto;

public class StatusVo {
	private String status;
	private int Key;
	private int statusCode = 200;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getKey() {
		return Key;
	}
	public void setKey(int key) {
		Key = key;
	}
	
}
