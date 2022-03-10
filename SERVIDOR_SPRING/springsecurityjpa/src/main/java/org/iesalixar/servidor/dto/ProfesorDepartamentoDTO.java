package org.iesalixar.servidor.dto;

import java.io.Serializable;
import java.util.List;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;

public class ProfesorDepartamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long profesor;
	private Long departamento;

	public ProfesorDepartamentoDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getProfesor() {
		return profesor;
	}

	public void setProfesor(Long profesor) {
		this.profesor = profesor;
	}

	public Long getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Long departamento) {
		this.departamento = departamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
