package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;

public interface ProfesorService {

	public List<Profesor> getAllProfesores();
	public Profesor findProfesorById(Long id);
	public Profesor actualizarProfesor(Profesor profesor);
	public Profesor insertarProfesorDepartamento (Profesor profesor);
	public List<Profesor> findDepartamentoIsNull();
	public Profesor insertarProfesor(Profesor profesor);
	public Profesor getProfesorByName(String nombre);
	
}
