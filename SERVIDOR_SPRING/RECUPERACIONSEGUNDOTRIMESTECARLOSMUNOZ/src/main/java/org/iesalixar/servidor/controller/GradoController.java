package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.services.GradoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradoController {
	
	@Autowired
	GradoServiceImpl gradoService;
	
	@RequestMapping("/")
	public String mostrarGrado(Model model) {
		
		List<Grado> grados = gradoService.getAllGrados();
		model.addAttribute("grados", grados);
		
		return "index";
	}
	
	@RequestMapping("/grados/estudiantes")
	public String mostrarGradosEstudiantes(@RequestParam(required=false, name="idGrado") String idGrado, Model model) {
		
		Optional<Grado> grados = gradoService.findGradoById(Long.parseLong(idGrado));
		
		if (grados.isPresent()) {
			model.addAttribute("grados", grados);
			model.addAttribute("asignaturas", grados.get().getAsignaturas());
			model.addAttribute("nombreGrado", grados.get().getNombre());
		}
		
		return "gradosEstudiantes";
	}
	
}
