package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

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
		
		List<Asignatura> asignBD = asignaturaRepo.findAll();
		
		if (asignBD != null && asignBD.size() > 0) {
			return asignBD;
		}
		
		return new ArrayList<Asignatura>();
	}

}
