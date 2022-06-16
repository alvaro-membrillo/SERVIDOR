package org.iesalixar.servidor.dto;

import java.io.Serializable;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.Asignatura;

public class AlumnoAsignaturaDTO implements Serializable {

//	private Alumno alumno;
//	private Asignatura asignatura;
	private Long grado;
	private Long asignatura;
	private Long nota;

	public AlumnoAsignaturaDTO() {
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

//	public Alumno getAlumno() {
//		return alumno;
//	}
//
//	public void setAlumno(Alumno alumno) {
//		this.alumno = alumno;
//	}
//
//	public Asignatura getAsignatura() {
//		return asignatura;
//	}
//
//	public void setAsignatura(Asignatura asignatura) {
//		this.asignatura = asignatura;
//	}

	public Long getNota() {
		return nota;
	}

	public void setNota(Long nota) {
		this.nota = nota;
	}

}
