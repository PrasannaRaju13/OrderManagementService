package com.order.item.dto;

public class OrderItemsDto {
	
	private int orderItemId;
	private String productCode;
	private String productName;
	private int quantity;
	
	public OrderItemsDto() {
	}
	
	

	public OrderItemsDto(int orderItemId, String productCode, String productName, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
	}


	public int getOrderItemId() {
		return orderItemId;
	}



	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}



	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
