package org.iesalixar.servidor.services;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.AlumnoAsignatura;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.repository.AlumnoAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoAsignaturaServiceImpl implements AlumnoAsignaturaService {

	@Autowired
	AlumnoAsignaturaRepository alumAsigRepo;
	
	@Override
	public AlumnoAsignatura actualizarAlumnoAsignatura(AlumnoAsignatura alumnoAsignatura) {
		
		if (alumnoAsignatura==null || alumnoAsignatura.getAlumno()==null || alumnoAsignatura.getAsignatura()==null) {
			return null;
		}
		
		return alumAsigRepo.save(alumnoAsignatura);
	}

//	@Override
//	public AlumnoAsignatura findAlumnoAsignaturaById(Alumno alumno, Asignatura asignatura) {
//		
//		if (alumno!=null && asignatura!=null) {
////			AlumnoAsignatura alumnoAsignatura = (AlumnoAsignatura) alumAsigRepo.findByAlumnoAndAsignatura(alumno, asignatura);			
////			return alumnoAsignatura;
//		}
//		
//		return null;
//	}
	
}
