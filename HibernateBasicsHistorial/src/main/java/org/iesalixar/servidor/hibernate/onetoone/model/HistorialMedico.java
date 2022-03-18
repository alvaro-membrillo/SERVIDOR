package org.iesalixar.servidor.hibernate.onetoone.model;

public class HistorialMedico {

	private int id;
	private String dni;

	public HistorialMedico() {
		// TODO Auto-generated constructor stub
	}

	public HistorialMedico(int id, String dni) {
		super();
		this.id = id;
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
