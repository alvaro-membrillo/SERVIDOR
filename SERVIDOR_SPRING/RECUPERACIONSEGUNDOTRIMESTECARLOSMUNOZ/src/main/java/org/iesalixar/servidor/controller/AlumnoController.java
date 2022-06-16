package org.iesalixar.servidor.controller;

import java.text.ParseException;
import java.util.Optional;

import org.iesalixar.servidor.dto.AlumnoAsignaturaNotaDTO;
import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.AlumnoAsignatura;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.services.AlumnoAsignaturaServiceImpl;
import org.iesalixar.servidor.services.AlumnoServiceImpl;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		Optional<Alumno> alumno = alumService.findAlumnoById(Long.parseLong(idAlumno));
		Optional<Asignatura> asignatura = asigService.findAsignaturaById(Long.parseLong(idAsignatura));
		
		model.addAttribute("alumno", alumno.get());
		model.addAttribute("asignatura", asignatura.get());
		
		for (AlumnoAsignatura alumAsignatura : alumno.get().getAlumnoAsignaturas()) {
			if (alumAsignatura.getAsignatura().getId() == asignatura.get().getId()) {
				model.addAttribute("alumnoAsignatura", alumAsignatura);
			}
		}
		
		return "editarNota";
	}
	
	@PostMapping("/estudiantes/editarnota")
	public String editarNotaPost(@ModelAttribute AlumnoAsignaturaNotaDTO alumAsigDTO, Model model) throws ParseException {
		
		AlumnoAsignatura alumAsig = new AlumnoAsignatura();
		Optional<Alumno> alumno = alumService.findAlumnoById(alumAsigDTO.getAlumno());
		Optional<Asignatura> asignatura = asigService.findAsignaturaById(alumAsigDTO.getAsignatura());
		
		alumAsig.setAlumno(alumno.get());
		alumAsig.setAsignatura(asignatura.get());
		alumAsig.setNota(alumAsigDTO.getNota());
		alumAsigService.actualizarAlumnoAsignatura(alumAsig);
		
		return "redirect:/grados/estudiantes?idGrado="+asignatura.get().getGrado().getId();
	}
	
}
