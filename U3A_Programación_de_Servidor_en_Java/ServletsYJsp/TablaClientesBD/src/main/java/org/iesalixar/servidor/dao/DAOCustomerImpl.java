package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Customer;


public class DAOCustomerImpl implements DAOCustomer {

	public DAOCustomerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer getCustomer(int customerNumber) {
		
		Customer customer = null;
		
		try {
			
			String sql = "select * from customers where customerNumber= ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, customerNumber);
			
			ResultSet rs = statement.executeQuery();
			
			//Como el campo de búsqueda es la clave solo debería obtener un resultado
			//si no es así estaremos machacando cada vez el valor de customer y 
			while (rs.next() ) {
				
				customer = new Customer();
				
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getDouble("creditLimit"));
				
			}
			
			ConexionBD.close();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		
		return customer;
		
	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		
		ArrayList<Customer> customersList = new ArrayList<>();
		Customer customer;
		
		try {
			
			String sql = "select * from customers";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);			
			
			ResultSet rs = statement.executeQuery();
			
			 
			while (rs.next() ) {
				
				customer = new Customer();
				
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getDouble("creditLimit"));
				
				customersList.add(customer);
				
			}
			
			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}		
		
		return customersList;
		
		
	}

}
