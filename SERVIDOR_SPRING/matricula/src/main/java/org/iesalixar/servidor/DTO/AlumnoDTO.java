package org.iesalixar.servidor.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDTO implements Serializable {

	private String nombre;
	private String apellidos;
	private String dni;
	private String curso;

	private List<String> materias;

	public AlumnoDTO() {
		materias = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<String> getMaterias() {
		return materias;
	}

	public void setMaterias(List<String> materias) {
		this.materias = materias;
	}

}
