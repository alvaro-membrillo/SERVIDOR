package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

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

		// Obtengo el resultado a través del repositorio
		List<Alumno> alumnBD = alumnRepo.findAll();

		// Verificando que he obtenido algo
		if (alumnBD != null && alumnBD.size() > 0) {

			return alumnBD;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Alumno>();
	}

}