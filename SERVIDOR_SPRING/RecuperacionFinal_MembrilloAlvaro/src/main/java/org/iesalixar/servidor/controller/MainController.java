package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.model.AlumnoAsignatura;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.services.AlumnoAsignaturaServiceImpl;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@Autowired
	AsignaturaServiceImpl asigService;
	
	@Autowired
	AlumnoAsignaturaServiceImpl alumAsigService;
	
	@RequestMapping("/")
	public String home(Model model) {
//		model.addAttribute("contenido","INICIO");
		
		List<Asignatura> asignaturas = asigService.getAllAsignaturas();
		model.addAttribute("asignaturas", asignaturas);
		
		List<AlumnoAsignatura> alumnoAsignaturas = alumAsigService.getAllAlumnoAsignatura();
		
		model.addAttribute("alumnoAsignatura", alumnoAsignaturas);
		model.addAttribute("numAlumnos", alumAsigService.getNumAlumnos());
		
		return "asignaturas";
	}

}
