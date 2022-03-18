package org.iesalixar.servidor.jdperez;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String usuario;
	private String password;	

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isUsuarioCorrecto() {
		
		return usuario.equals("admin") && password.equals("admin");
	}
		

}
