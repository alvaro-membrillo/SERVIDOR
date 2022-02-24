package org.iesalixar.servidor.model;

import java.io.Serializable;

public class OrderDetails implements Serializable {

	private int orderNumber;
	private String productCode;
	private int quantityOrdered;
	private int priceEach;
	private int orderLineNumber;

	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int orderNumber, String productCode, int quantityOrdered, int priceEach, int orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public int getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(int priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

}
