package org.iesalixar.servidor.services;

import java.util.ArrayList;
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

		List<Grado> gradoBD = gradoRepo.findAll();

		if (gradoBD != null && gradoBD.size() > 0) {

			return gradoBD;
		}

		return new ArrayList<Grado>();
	}

	@Override
	public Grado findGradoById(Long id) {
		if (id!=null) {
			return gradoRepo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Grado insertarGrado(Grado grado) {

		// ¿Por qué da error la segunda condición?
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

	@Override
	public Grado actualizarGrado(Grado grado) {

		if (grado == null || grado.getId() == null || grado.getNombre() == null) {
			return null;
		}

		return gradoRepo.save(grado);
	}

}
