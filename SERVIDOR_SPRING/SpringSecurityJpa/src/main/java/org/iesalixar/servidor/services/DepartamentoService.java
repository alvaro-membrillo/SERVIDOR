package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Departamento;

public interface DepartamentoService {
	
	public List<Departamento> getAllDepartments();
	public Departamento getDepartamentByName(String nombre);
	public Departamento insertaDepartamento(Departamento departamento);
	public Departamento actualizarDepartamento(Departamento departamento);
	
}
