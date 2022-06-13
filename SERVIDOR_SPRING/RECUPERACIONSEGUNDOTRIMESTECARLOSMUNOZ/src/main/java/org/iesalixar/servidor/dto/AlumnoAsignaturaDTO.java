package org.iesalixar.servidor.dto;

public class AlumnoAsignaturaDTO {

	private Long idAlumno;
	private Long idAsignatura;
	private int nota;

	public AlumnoAsignaturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Long getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(Long idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
