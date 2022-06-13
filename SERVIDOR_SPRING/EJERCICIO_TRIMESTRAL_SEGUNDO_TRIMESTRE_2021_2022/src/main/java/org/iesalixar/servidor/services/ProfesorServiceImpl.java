package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

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

		return profRepo.findAll();
	}

	@Override
	public Profesor findProfesorByNif(String nif) {

		if (nif != null && !nif.equals("")) {
			return profRepo.findByNif(nif);
		}

		return null;
	}

	@Override
	public Profesor insertarProfesor(Profesor profesor) {

		if (profesor != null && profesor.getId() == null) {
			return profRepo.save(profesor);
		}

		return null;
	}

	@Override
	public Optional<Profesor> findProfesorById(Long id) {

		if (id != null) {
			return profRepo.findById(id);
		}

		return null;
	}

	@Override
	public Profesor actualizarProfesor(Profesor profesor) {

		if (profesor != null && profesor.getId() != null) {
			return profRepo.save(profesor);
		}
		return null;
	}

	@Override
	public Profesor getProfesorByNif(String nif) {

		if (nif != null) {
			Profesor profesor = profRepo.findByNif(nif);
			return profesor;
		}

		return null;
	}

}
