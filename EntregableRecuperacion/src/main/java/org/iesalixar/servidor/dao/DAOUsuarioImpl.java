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

		try {
			PoolDB pool = new PoolDB();
			Connection con = pool.getConnection();

			String sql = "select * from usuarios where email=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setUsuario(rs.getString("usuario"));
				usuario.setFirstName(rs.getString("firstName"));
				usuario.setLastName(rs.getString("lastName"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
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

	@Override
	public boolean registerUsuario(Usuario usuario) {
		int resultado = 0;

		try {

			PoolDB pool = new PoolDB();
			Connection con = pool.getConnection();

			String sql = "insert into usuarios values(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getFirstName());
			statement.setString(3, usuario.getLastName());
			statement.setString(4, usuario.getPassword());
			statement.setString(5, usuario.getEmail());
			statement.setString(6, usuario.getRole());
			statement.setString(7, usuario.getFirstName());
			statement.setString(8, usuario.getLastName());

			resultado = statement.executeUpdate();

			con.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
	}

}
