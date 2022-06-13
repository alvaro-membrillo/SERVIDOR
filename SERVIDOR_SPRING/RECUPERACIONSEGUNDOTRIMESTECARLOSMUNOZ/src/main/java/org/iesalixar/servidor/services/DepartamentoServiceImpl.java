package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepo;

	@Override
	public List<Departamento> getAllDepartamentos() {

		List<Departamento> departamentos = departamentoRepo.findAll();

		if (departamentos != null && departamentos.size() > 0) {
			
			return departamentos;
		}

		return new ArrayList<Departamento>();
	}

	@Override
	public Departamento findDepartamentoById(Long id) {
		
		if (id != null) {
			return departamentoRepo.findById(id).get();
		}
		
		return null;
	}

}
