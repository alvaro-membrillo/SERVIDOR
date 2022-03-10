package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

public class GradoAsignaturaId implements Serializable {

	private Long grado;
	private Long asignatura;

	public GradoAsignaturaId() {
		// TODO Auto-generated constructor stub
	}

	public Long getGrado() {
		return grado;
	}

	public void setGrado(Long grado) {
		this.grado = grado;
	}

	public Long getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Long asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignatura, grado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradoAsignaturaId other = (GradoAsignaturaId) obj;
		return Objects.equals(asignatura, other.asignatura) && Objects.equals(grado, other.grado);
	}

}
