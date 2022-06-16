package org.iesalixar.servidor.repository;

import java.util.List;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	
//	public List<Alumno> findByAsignatura(Long asignatura);
	
}
