package org.iesalixar.servidor.services;

import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;

public interface ProfesorService {

	public Optional<Profesor> findProfesorById(Long id);
	public Profesor actualizarProfesor(Profesor profesor);
	
}
