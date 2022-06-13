package org.iesalixar.servidor.dto;

import java.io.Serializable;

public class ProfesorAsignaturaDTO implements Serializable {

	private String nifProfesor;
	private String idAsignatura;

	public ProfesorAsignaturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getNifProfesor() {
		return nifProfesor;
	}

	public void setNifProfesor(String nifProfesor) {
		this.nifProfesor = nifProfesor;
	}

	public String getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(String idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

}
