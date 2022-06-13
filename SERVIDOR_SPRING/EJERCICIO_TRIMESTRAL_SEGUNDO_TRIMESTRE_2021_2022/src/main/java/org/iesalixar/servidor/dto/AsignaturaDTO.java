package org.iesalixar.servidor.dto;

import java.io.Serializable;

public class AsignaturaDTO implements Serializable {

	private Long id;
	private String nombre;
	private Long idProfesor;

	public AsignaturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

}
