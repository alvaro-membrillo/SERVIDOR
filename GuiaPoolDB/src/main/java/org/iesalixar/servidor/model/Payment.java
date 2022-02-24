package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.sql.Date;

public class Payment implements Serializable {
	
	private int customerNumber;
	private String checkNumber;
	private Date paymentDate;
	private int amount;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int customerNumber, String checkNumber, Date paymentDate, int amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
