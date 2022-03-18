package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Departamento;
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
	
	@Override
	public Grado insertaGrado(Grado grado) {

		if (grado != null && getGradoByName(grado.getNombre()) == null) {
			Grado degree = gradoRepo.save(grado);
			return degree;
		}

		return null;
	}
	
	@Override
	public Grado getGradoByName(String nombre) {

		if (nombre != null) {
			Grado grado = gradoRepo.findByNombre(nombre);
			return grado;
		}

		return null;
	}

}
