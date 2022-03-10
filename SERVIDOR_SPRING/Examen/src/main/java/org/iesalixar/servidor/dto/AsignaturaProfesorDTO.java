package org.iesalixar.servidor.dto;

import java.io.Serializable;
import java.util.List;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;

public class AsignaturaProfesorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long profesor;
	private Long asignatura;

	public AsignaturaProfesorDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getProfesor() {
		return profesor;
	}

	public void setProfesor(Long profesor) {
		this.profesor = profesor;
	}

	public Long getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Long asignatura) {
		this.asignatura = asignatura;
	}

}
