package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.ProductLines;

public class DAOProductLinesImpl implements DAOProductLines {

	@Override
	public List<ProductLines> GetProductLines() {
		Connection con = null;
		List<ProductLines> productos = null;

		try {
			String sql = "select * from productlines where productline=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				/*usuario = new Usuario();
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuario.setRole(rs.getString("role"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));*/
			}

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return productos;
	}

}
