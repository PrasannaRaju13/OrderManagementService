package com.order.service.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="orders")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_Id")
	private int orderId;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="shipping_address")
	private String shippingAddress;
	@Column(name="total_price")
	private double total;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	@JsonManagedReference
	private List<OrderServiceItem> orderServiceItem;
	
	public Order() {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<OrderServiceItem> getOrderServiceItem() {
		return orderServiceItem;
	}

	public void setOrderServiceItem(List<OrderServiceItem> orderServiceItem) {
		this.orderServiceItem = orderServiceItem;
	}
	
	

}
