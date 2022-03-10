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
@Table(name = "profesor_imparte_asignatura")
@IdClass(ProfesorAsignaturaId.class)
public class ProfesorAsignatura implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_profesor", insertable = false, updatable = false)
	private Profesor profesor;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_asignatura", insertable = false, updatable = false)
	private Asignatura asignatura;

	public ProfesorAsignatura() {
		// TODO Auto-generated constructor stub
	}

	public ProfesorAsignatura(Profesor profesor, Asignatura asignatura) {
		super();
		this.profesor = profesor;
		this.asignatura = asignatura;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
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
		ProfesorAsignatura other = (ProfesorAsignatura) obj;
		return Objects.equals(asignatura, other.asignatura) && Objects.equals(profesor, other.profesor);
	}

}
