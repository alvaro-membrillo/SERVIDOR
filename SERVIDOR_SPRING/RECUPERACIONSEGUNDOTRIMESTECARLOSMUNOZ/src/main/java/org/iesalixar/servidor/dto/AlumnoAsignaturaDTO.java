package org.iesalixar.servidor.dto;

public class AlumnoAsignaturaDTO {

	private Long alumno;
	private Long asignatura;
	private int nota;

	public AlumnoAsignaturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getAlumno() {
		return alumno;
	}

	public void setAlumno(Long alumno) {
		this.alumno = alumno;
	}

	public Long getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Long asignatura) {
		this.asignatura = asignatura;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
