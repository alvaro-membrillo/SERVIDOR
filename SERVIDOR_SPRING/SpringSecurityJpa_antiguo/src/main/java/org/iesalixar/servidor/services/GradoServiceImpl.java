package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GradoServiceImpl implements GradoService {

	@Autowired
	GradoRepository gradoRepo;

	@Override
	public List<Grado> getAllGrados() {
		
		List<Grado> gradoBD = gradoRepo.findAll();
		
		if (gradoBD != null && gradoBD.size() > 0) {
			
			return gradoBD;
		}
		
		return new ArrayList<Grado>();
	}

	@Override
	public Optional<Grado> findGradoById(Long id) {
		
		Optional<Grado> grado = null;
		
		if (id != null) {
			grado = gradoRepo.findById(id);
		}
		
		return grado;
	}

}
