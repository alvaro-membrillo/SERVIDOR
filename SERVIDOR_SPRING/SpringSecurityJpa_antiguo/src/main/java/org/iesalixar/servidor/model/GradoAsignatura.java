package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grado_asignatura")
@IdClass(GradoAsignaturaId.class)
public class GradoAsignatura implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_grado", insertable = false, updatable = false)
	private Grado grado;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_asignatura", insertable = false, updatable = false)
	private Asignatura asignatura;

	public GradoAsignatura() {
		// TODO Auto-generated constructor stub
	}

	public GradoAsignatura(Grado grado, Asignatura asignatura) {
		super();
		this.grado = grado;
		this.asignatura = asignatura;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
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
		GradoAsignatura other = (GradoAsignatura) obj;
		return Objects.equals(asignatura, other.asignatura) && Objects.equals(grado, other.grado);
	}

}
