package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.services.AlumnoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlumnoController {

	@Autowired
	AlumnoServiceImpl alumnoService;
	
	@RequestMapping("/alumnos")
	public String alumnos(Model model) {
		
		List<Alumno> alumnos = alumnoService.getAllAlumnos();
		
		model.addAttribute("contenido","ALUMNOS");
		model.addAttribute("alumnos",alumnos);
		return "alumnos";
	}
	
	/*@GetMapping("/alumnos/add")
	public String addAlumnoGet(Model model) {
		return "addAlumno";
	}
	
	@PostMapping("/alumnos/add")
	public String addAlumnoPost(@ModelAttribute AlumnoDTO alumn, Model model) {
		
		Alumno alumnBD = new Alumno();
		alumnBD.setNif(alumn.getNif());
		
		if (alumnoService.insertaAlumno(alumnBD) == null) {
			return "redirect:/alumnos/add";
		}
		
		return "redirect:/alumnos";
	}*/

}