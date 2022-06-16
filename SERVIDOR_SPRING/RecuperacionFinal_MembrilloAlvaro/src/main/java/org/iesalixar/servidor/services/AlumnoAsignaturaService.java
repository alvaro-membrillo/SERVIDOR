package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.AlumnoAsignatura;
import org.iesalixar.servidor.model.Asignatura;

public interface AlumnoAsignaturaService {

	public List<AlumnoAsignatura> getAllAlumnoAsignatura();
	public Long getNumAlumnos();
	public Optional<AlumnoAsignatura> getAlumnoAsignatura(AlumnoAsignatura alumAsig);
	public AlumnoAsignatura insertarAa(AlumnoAsignatura alumnoAsignatura);
	public AlumnoAsignatura getAlumAsigByAsignatura(Asignatura asignatura);
	
}
