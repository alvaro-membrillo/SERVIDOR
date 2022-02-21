package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnRepo;

	@Override
	public List<Alumno> getAllAlumnos() {

		return alumnRepo.findAll();
	}

	@Override
	public Optional<Alumno> findAlumnoById(Long id) {

		return alumnRepo.findById(id);
	}

}
