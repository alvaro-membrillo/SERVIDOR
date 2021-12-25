package org.iesalixar.servidor.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String usuario, password, email, role;
	
	public User() {
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	

}
