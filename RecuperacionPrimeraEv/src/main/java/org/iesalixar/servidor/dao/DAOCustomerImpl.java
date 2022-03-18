package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Payment;
import org.iesalixar.servidor.model.Order;

public class DAOCustomerImpl implements DAOCustomer {

	@Override
	public List<Customer> getAllCustomers() {

		ArrayList<Customer> customerList = new ArrayList<>();
		Customer customer;
		Connection con = null;

		try {
			String sql = "select * from customers";

			PoolDB pool = new PoolDB();

			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				customer = new Customer();

				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getInt("creditLimit"));

				customerList.add(customer);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return customerList;

	}

	@Override
	public double getTotalPagos(int customerNumber) {

		double pagosTotal = 0;
		Payment payment = null;
		Connection con = null;

		try {
			String sql = "Select sum(amount) from payments where customerNumber=?";

			PoolDB pool = new PoolDB();

			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				payment = new Payment();

				pagosTotal += payment.getAmount();

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return pagosTotal;
	}

	@Override
	public int numeroPedidos(int customerNumber) {
		int numPedidos = 0;
		Order order = null;
		Connection con = null;

		try {
			String sql = "Select count(orderNumber) from orders where customerNumber=?";

			PoolDB pool = new PoolDB();

			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				order = new Order();

				numPedidos += order.getCustomerNumber();

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return numPedidos;
	}

}
