package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Customer;

public interface DAOCustomer {
	
	public List<Customer> getAllCustomers();
	public double getTotalPagos(int customerNumber);
	public int numeroPedidos(int customerNumber);

}
