package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;

public interface ProfesorService {
	
	public List<Profesor> getAllProfesores();
	public Profesor findProfesorByNif(String nif);
	public Optional<Profesor> findProfesorById(Long id);
	public Profesor insertarProfesor(Profesor profesor);
	public Profesor actualizarProfesor(Profesor profesor);
	public Profesor getProfesorByNif(String nif);
}
