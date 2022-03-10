package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	ProfesorRepository profRepo;

	@Override
	public List<Profesor> getAllProfesores() {

		// Obtengo el resultado a través del repositorio
		List<Profesor> profesorBD = profRepo.findAll();

		// Verificando que he obtenido algo
		if (profesorBD != null && profesorBD.size() > 0) {

			return profesorBD;
		}

		// No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Profesor>();
	}

	@Override
	public Profesor findProfesorById(Long id) {
		
		return profRepo.findById(id).get();
	}

	@Override
	public Profesor actualizarProfesor(Profesor profesor) {
		if (profesor == null || profesor.getId() == null) {
			return null;
		}

		return profRepo.save(profesor);
	}

	@Override
	public Profesor insertarProfesorDepartamento(Profesor profesor) {

		if (profesor != null) {

			Profesor prof = profRepo.save(profesor);
			return prof;

		}

		return null;

	}

	@Override
	public List<Profesor> findDepartamentoIsNull() {

		List<Profesor> profesores = profRepo.findByDepartamentoIsNull();

		if (profesores != null && profesores.size() > 0) {

			return profesores;

		}

		return new ArrayList<Profesor>();

	}

	@Override
	public Profesor insertarProfesor(Profesor profesor) {
		if (profesor!=null && getProfesorByName(profesor.getNombre())==null) {
			Profesor prof = profRepo.save(profesor);
			return prof;
		}
		
		return null;
	}

	@Override
	public Profesor getProfesorByName(String nombre) {
		
		if (nombre!=null) {
			
			Profesor prof = profRepo.findByNombre(nombre);
			
			return prof;			
		}
		
		return null;
	}

}
