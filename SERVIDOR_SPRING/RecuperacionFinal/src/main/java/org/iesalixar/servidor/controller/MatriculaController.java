package org.iesalixar.servidor.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {
	
	@Autowired
	AlumnoAsignaturaServiceImpl aaService;
	
	@Autowired
	AlumnoServiceImpl alumService;
	
	@Autowired
	AsignaturaServiceImpl asigService;
	
	@RequestMapping("/add")
	public String addMatricula(@RequestParam(required=false, name="codigo") String codigo, Model model) {
		AlumnoAsignaturaDTO alumAsigDTO = new AlumnoAsignaturaDTO();
		List<Alumno> alumnos = alumService.getAllAlumnos();
		Optional<Asignatura> asignatura = asigService.findAsignaturaById(Long.parseLong(codigo));
		
		model.addAttribute("alumnoAsignatura", alumAsigDTO);
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("asignatura", asignatura.get());
		
		return "addMatricula";
	}
	
	@PostMapping("/add")
	public String addMatriculaPost(@ModelAttribute AlumnoAsignaturaDTO alumAsigDTO, Model model) {

		AlumnoAsignatura alumAsigBD = new AlumnoAsignatura();
//		alumAsigBD.setAlumno(alumAsigDTO.getAlumno());
//		alumAsigBD.setAsignatura(alumAsigDTO.getAsignatura());
		alumAsigBD.setNota(alumAsigDTO.getNota());

		if (aaService.insertarAa(alumAsigBD) == null) {
			return "redirect:/matricula/add?error=Existe&grado" + alumAsigDTO.getAsignatura();
		}

		return "redirect:/";
	}
	
	@RequestMapping("/list")
	public String listMatricula(@RequestParam(required=false, name="codigo") String codigo, Model model) {
//		AlumnoAsignaturaDTO alumAsigDTO = new AlumnoAsignaturaDTO();
//		Asignatura asignatura = asigService.findAsignaturaById(Long.parseLong(codigo)).get();
//		List<Alumno> alumnos = alumService.getAlumnosByAsignatura(Long.parseLong(codigo));
		
//		model.addAttribute("alumnosAsignatura", alumnos);
		
		return "listaMatricula";
	}
	
	@RequestMapping("/report")
	public String reportMatricula(@RequestParam(required=false, name="codigo") String codigo, Model model) {
		AlumnoAsignaturaDTO alumAsigDTO = new AlumnoAsignaturaDTO();
		Optional<Asignatura> asignatura = asigService.findAsignaturaById(Long.parseLong(codigo));
//		List<Alumno> alumnos = alumService.getAllAlumnos();
//		List<Alumno> alumnos = alumService.getAlumnosByAsignatura(asignatura);
		
		model.addAttribute("alumnoAsignatura", alumAsigDTO);
//		model.addAttribute("alumnos", alumnos);
		model.addAttribute("asignatura", asignatura.get());
		
		return "reportMatricula";
	}
	
}
