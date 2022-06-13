package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.repository.GradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradoServiceImpl implements GradoService {

	@Autowired
	GradoRepository gradoRepo;
	
	@Override
	public List<Grado> getAllGrados() {
		
		return gradoRepo.findAll();
	}

	@Override
	public Optional<Grado> findGradoById(Long id) {
		
		return gradoRepo.findById(id);
	}

}
