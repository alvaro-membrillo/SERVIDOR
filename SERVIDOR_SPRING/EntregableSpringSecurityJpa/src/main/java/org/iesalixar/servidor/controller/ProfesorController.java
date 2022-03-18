package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {
	
	@Autowired
	ProfesorServiceImpl profesorService;
	
	@GetMapping("")
	public String profesores(Model model) {
		
		List<Profesor> profesores = profesorService.getAllProfesores();
		model.addAttribute("profesores", profesores);
		
		return "profesores";
	}
	
	@GetMapping("profesores")
	public String profesorAsignatura(@RequestParam(required=false,name="codigo")String codigo, Model model) {
		if (codigo == null) {
			return "redirect:/profesores/";
		}
		
		Optional<Profesor> profesor = profesorService.findProfesorById(Long.parseLong(codigo));
		return "profesorAsignaturas";
	}
	
}
