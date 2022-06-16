package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumRepo;
	
	@Override
	public List<Alumno> getAllAlumnos() {
		return alumRepo.findAll();
	}

	@Override
	public List<Alumno> getAlumnosByAsignatura(Asignatura asignatura) {
		return null;
//		return alumRepo.findById(null);
//		return alumRepo.findByAsignatura(asignatura);
//		return alumRepo.findByAsignatura(asignatura);
	}

}
