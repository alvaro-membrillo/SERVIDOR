package org.iesalixar.servidor.repository;

import java.util.Optional;

import org.iesalixar.servidor.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
	
	public Departamento findByNombre(String nombre);
	public Optional<Departamento> findById(Long id);
	
}
