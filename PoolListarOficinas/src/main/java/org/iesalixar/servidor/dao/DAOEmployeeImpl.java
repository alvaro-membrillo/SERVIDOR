package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class DAOEmployeeImpl implements DAOEmployee {

	@Override
	public ArrayList<Employee> getAllEmployeesFromOffice(String officeCode) {

		ArrayList<Employee> employeesList = new ArrayList<>();
		Employee employee = null;
		Connection con = null;
		
		try {
			String sql = "select * from employees where officeCode = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				employee = new Employee();

				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setJobTitle(rs.getString("jobTitle"));

				employeesList.add(employee);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return employeesList;
	}

}
