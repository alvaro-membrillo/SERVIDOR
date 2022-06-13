package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Departamento;

public interface DepartamentoService {

	public List<Departamento> getAllDepartamentos();
	public Departamento findDepartamentoById(Long id);
	
}
