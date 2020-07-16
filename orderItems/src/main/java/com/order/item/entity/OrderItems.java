package com.order.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_items")
public class OrderItems implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6498574018670240073L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_item_id")
	private int orderItemId;
	@Column(name="product_code")
	private String productCode;
	@Column(name="product_name")
	private String productName;
	@Column(name="quantity")
	private int quantity;
	
	public OrderItems() {
		
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
