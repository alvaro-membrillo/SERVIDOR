package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

public class ProfesorAsignaturaId implements Serializable {

	private Long profesor;
	private Long asignatura;

	public ProfesorAsignaturaId() {
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

	@Override
	public int hashCode() {
		return Objects.hash(asignatura, profesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfesorAsignaturaId other = (ProfesorAsignaturaId) obj;
		return Objects.equals(asignatura, other.asignatura) && Objects.equals(profesor, other.profesor);
	}

}
