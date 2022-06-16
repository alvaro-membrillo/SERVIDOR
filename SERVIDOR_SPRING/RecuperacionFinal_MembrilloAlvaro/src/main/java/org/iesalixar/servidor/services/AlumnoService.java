package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.Asignatura;

public interface AlumnoService {
	
	public List<Alumno> getAllAlumnos();
	public List<Alumno> getAlumnosByAsignatura(Asignatura asignatura);
	
}
