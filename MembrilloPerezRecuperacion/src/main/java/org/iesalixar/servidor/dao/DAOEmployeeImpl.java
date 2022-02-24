package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class DAOEmployeeImpl implements DAOEmployee {

	@Override
	public List<Employee> getAllEmployees() {

		ArrayList<Employee> listaEmpleados = new ArrayList<>();
		Employee empleado = null;
		Connection con = null;
		try {
			String sql = "select * from employees";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				empleado = new Employee();
				empleado.setEmployeeNumber(rs.getInt("employeeNumber"));
				empleado.setLastName(rs.getString("lastName"));
				empleado.setFirstName(rs.getString("firstName"));
				empleado.setExtension(rs.getString("extension"));
				empleado.setEmail(rs.getString("email"));
				empleado.setOfficeCode(rs.getString("officeCode"));
				empleado.setReportsTo(rs.getInt("reportsTo"));
				empleado.setJobTitle(rs.getString("jobTitle"));

				listaEmpleados.add(empleado);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listaEmpleados;
	}

}
