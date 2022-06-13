package org.iesalixar.servidor.services;

import java.util.Optional;

import org.iesalixar.servidor.model.Alumno;

public interface AlumnoService {
	
	public Optional<Alumno> findAlumnoById(Long id);
}
