package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	AsignaturaRepository asignaturaRepo;

	@Override
	public List<Asignatura> getAllAsignaturas() {

		List<Asignatura> asignaturas = asignaturaRepo.findAll();

		if (asignaturas != null && asignaturas.size() > 0) {
			return asignaturas;
		}

		return new ArrayList<Asignatura>();
	}

	@Override
	public Optional<Asignatura> getAsignaturaById(Long id) {

		if (id != null) {
			Optional<Asignatura> asignatura = asignaturaRepo.findById(id);
			return asignatura;
		}

		return null;
	}

	@Override
	public Optional<Asignatura> findAsignaturaById(Long id) {
		
		Optional<Asignatura> asignatura = null;
		
		if (id != null) {
			asignatura = asignaturaRepo.findById(id);
		}
		
		return asignatura;
	}

	@Override
	public Asignatura actualizarAsignatura(Asignatura asignatura) {
		
		if (asignatura==null || asignatura.getId()==null || asignatura.getNombre()==null) {
			return null;
		}
		
		return asignaturaRepo.save(asignatura);
	}

}
