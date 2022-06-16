package org.iesalixar.servidor.repository;

import org.iesalixar.servidor.model.AlumnoAsignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoAsignaturaRepository extends JpaRepository<AlumnoAsignatura, Long>{

}
