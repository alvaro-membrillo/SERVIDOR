package org.iesalixar.servidor.controller;

import java.util.Optional;

import org.iesalixar.servidor.dto.AlumnoAsignaturaDTO;
import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.AlumnoAsignatura;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.services.AlumnoAsignaturaServiceImpl;
import org.iesalixar.servidor.services.AlumnoServiceImpl;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlumnoController {
	
	@Autowired
	AlumnoAsignaturaServiceImpl alumAsigService;
	
	@Autowired
	AlumnoServiceImpl alumService;
	
	@Autowired
	AsignaturaServiceImpl asigService;
	
	@RequestMapping("/estudiantes/editarnota")
	public String editarNota(@RequestParam(required=false, name="idAlumno") String idAlumno, @RequestParam(required=false,name="idAsignatura") String idAsignatura, Model model) {
		
//		model.addAttribute("nombreAsignatura", asignaturaService.findAsignaturaById(Long.parseLong(idAlumno)).get().getNombre());
		Optional<Alumno> alumno = alumService.findAlumnoById(Long.parseLong(idAsignatura));
		Optional<Asignatura> asignatura = asigService.findAsignaturaById(Long.parseLong(idAsignatura));
		
		model.addAttribute("nombreAsignatura", asignatura.get().getNombre());
		model.addAttribute("nombreAlumno", alumno.get().getNombre()+" "+alumno.get().getApellido1());
		
		for (AlumnoAsignatura alumAsignatura : alumno.get().getAlumnoAsignaturas()) {
			if (alumAsignatura.getAsignatura().getId() == asignatura.get().getId()) {
				model.addAttribute("alumnoAsignatura", alumAsignatura);
			}
		}
		
		return "editarNota";
	}
	
	@PostMapping("/estudiantes/editarnota")
	public String editarNotaPost(@RequestParam(required=false, name="asig") String asig, @RequestParam(required=false, name="alum") String alum, @RequestAttribute AlumnoAsignaturaDTO alumAsigDTO, Model model) {
		
		AlumnoAsignatura alumAsig = new AlumnoAsignatura();
		Optional<Alumno> alumno = alumService.findAlumnoById(alumAsigDTO.getIdAlumno());
		Optional<Asignatura> asignatura = asigService.findAsignaturaById(alumAsig.getAsignatura().getId());
		
		
//		AlumnoAsignatura alumAsig = alumAsigService.findAlumnoAsignaturaById(alumService.findAlumnoById(alum).get(), asigService.findAsignaturaById(Long.parseLong(asig)).get());
//		alumAsigService.actualizarAlumnoAsignatura(alumAsig);
		
		return "editarNota";
	}
	
}
