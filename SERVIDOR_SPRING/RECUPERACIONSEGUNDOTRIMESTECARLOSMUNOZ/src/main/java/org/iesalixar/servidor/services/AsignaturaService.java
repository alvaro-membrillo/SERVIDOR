package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;

public interface AsignaturaService {
	
	public List<Asignatura> getAllAsignaturas();
	public Optional<Asignatura> getAsignaturaById(Long id);
	public Optional<Asignatura> findAsignaturaById(Long id);
	public Asignatura actualizarAsignatura(Asignatura asignatura);
	
}
