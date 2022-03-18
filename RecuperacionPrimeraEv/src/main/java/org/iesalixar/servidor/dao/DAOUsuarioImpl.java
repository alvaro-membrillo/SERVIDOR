package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {

	@Override
	public Usuario getUsuario(String email) {

		Usuario usuario = null;
		Connection con = null;

		try {
			String sql = "select * from usuarios where email=?";
			PoolDB pool = new PoolDB();

			con = pool.getConnection();

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setUsuario(rs.getString("usuario"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuario.setRole(rs.getString("role"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));

			}

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return usuario;

	}

}
