package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.iesalixar.servidor.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {

	@Override
	public Usuario getUsuario(String email) {
		
		Usuario usuario = null;
		Connection con = null;
		
		try {
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return usuario;
		
	}

}
