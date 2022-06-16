package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.AlumnoAsignatura;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.repository.AlumnoAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AlumnoAsignaturaServiceImpl implements AlumnoAsignaturaService {

	@Autowired
	AlumnoAsignaturaRepository alumAsigRepo;
	
	@Override
	public List<AlumnoAsignatura> getAllAlumnoAsignatura() {
		return alumAsigRepo.findAll();
	}

	@Override
	public Long getNumAlumnos() {
		return alumAsigRepo.count();
	}

	@Override
	public Optional<AlumnoAsignatura> getAlumnoAsignatura(AlumnoAsignatura alumAsig) {
		return null;
	}

	@Override
	public AlumnoAsignatura insertarAa(AlumnoAsignatura alumnoAsignatura) {
		return alumAsigRepo.save(alumnoAsignatura);
	}

	@Override
	public AlumnoAsignatura getAlumAsigByAsignatura(Asignatura asignatura) {
		return null;
	}
	
}
