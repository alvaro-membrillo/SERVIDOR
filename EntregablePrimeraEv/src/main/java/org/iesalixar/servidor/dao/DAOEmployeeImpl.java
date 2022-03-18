package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Employee;

public class DAOEmployeeImpl implements DAOEmployee {

	@Override
	public ArrayList<Employee> getAllEmployees() {
		
		ArrayList<Employee> employeesList = new ArrayList<>();
		//Employee employee;

		try {

			String sql = "select * from employees";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Employee employee = new Employee();

				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));

				employeesList.add(employee);

			}

			ConexionBD.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return employeesList;
		
	}

	@Override
	public ArrayList<Employee> getEmployeeSearch(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(String firstName) {
		
		Employee employee = null;
		
		try {
			String sql = "select * from employees where firstName";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, firstName);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				employee = new Employee();
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
			}
			
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}
		
		
		return null;
	}

	@Override
	public boolean removeEmployee(int employeeNumber) {
		int resultado = 0;

		try {

			String sql = "delete from employees where employeeNumber=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, employeeNumber);

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		int resultado = 0;

		try {

			String sql = "update employees set lastName= ?, firstName=?, extension=?, email=?, jobTitle=? where employeeNumber = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, employee.getLastName());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getExtension());
			statement.setString(4, employee.getEmail());
			statement.setString(5, employee.getJobTitle());

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		int resultado = 0;

		try {

			String sql = "insert into employees values(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setInt(1, employee.getEmployeeNumber());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getFirstName());
			statement.setString(4, employee.getExtension());
			statement.setString(5, employee.getEmail());
			statement.setString(6, employee.getOfficeCode());
			statement.setInt(7, employee.getReportsTo());
			statement.setString(8, employee.getJobTitle());

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

}
