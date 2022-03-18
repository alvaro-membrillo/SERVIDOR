package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.bd.PoolDBContext;
import org.iesalixar.servidor.model.Office;

public class DAOOfficeImpl implements DAOOffice {

	@Override
	public List<Office> getAllOffices() {

		ArrayList<Office> officesList = new ArrayList<>();
		Office office = null;
		Connection con = null;
		try {

			String sql = "select * from offices";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				office = new Office();
				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setState(rs.getString("state"));
				office.setCountry(rs.getString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));

				officesList.add(office);

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

		return officesList;

	}

	@Override
	public List<Office> getAllOfficesContext() {
		ArrayList<Office> officesList = new ArrayList<>();
		Office office = null;
		Connection con = null;
		try {

			String sql = "select * from offices";
			PoolDBContext pool = new PoolDBContext();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				office = new Office();
				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setState(rs.getString("state"));
				office.setCountry(rs.getString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));

				officesList.add(office);

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

		return officesList;

	}

}
