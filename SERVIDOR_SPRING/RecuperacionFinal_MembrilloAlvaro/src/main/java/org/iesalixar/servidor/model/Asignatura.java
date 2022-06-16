package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "asignatura")
public class Asignatura implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private Double creditos;

	@Column(nullable = false)
	private String tipo;

	@Column(nullable = false)
	private Integer curso;

	@Column(nullable = false)
	private Integer cuatrimestre;

	@OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<AlumnoAsignatura> alumnosAsignatura = new HashSet<>();

//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_profesor")
	private Profesor profesor;

//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_grado")
	private Grado grado;

	public Asignatura() {
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

	public Double getCreditos() {
		return creditos;
	}

	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	public Integer getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(Integer cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Set<AlumnoAsignatura> getAlumnosAsignatura() {
		return alumnosAsignatura;
	}

	public void setAlumnosAsignatura(Set<AlumnoAsignatura> alumnosAsignatura) {
		this.alumnosAsignatura = alumnosAsignatura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumnosAsignatura, creditos, cuatrimestre, curso, grado, id, nombre, profesor, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(alumnosAsignatura, other.alumnosAsignatura) && Objects.equals(creditos, other.creditos)
				&& Objects.equals(cuatrimestre, other.cuatrimestre) && Objects.equals(curso, other.curso)
				&& Objects.equals(grado, other.grado) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(profesor, other.profesor)
				&& Objects.equals(tipo, other.tipo);
	}

}
