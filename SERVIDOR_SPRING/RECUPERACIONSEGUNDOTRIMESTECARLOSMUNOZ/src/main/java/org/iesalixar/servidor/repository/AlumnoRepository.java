package org.iesalixar.servidor.repository;

import java.util.Optional;

import org.iesalixar.servidor.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	
	Optional<Alumno> findByNif(String nif);

}
