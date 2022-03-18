package org.iesalixar.servidor.controller;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.DTO.AlumnoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("/matricula")
	public String matricula(Model model) {
		
		List<String> cursos = new ArrayList<>();
		List<String> materias = new ArrayList<>();
		
		cursos.add("DAW 1");
		cursos.add("DAW 2");
		
		materias.add("DAW");
		materias.add("DWES");
		materias.add("DWEC");
		materias.add("EINEM");
		materias.add("DIW");
		
		model.addAttribute("alumno", new AlumnoDTO());
		model.addAttribute("cursos", cursos);
		model.addAttribute("materias", materias);
		
		return "matricula";
	}

	@PostMapping("/matricula")
	public String matricula(@ModelAttribute AlumnoDTO alumno, Model model) {
		
		model.addAttribute("alumno", alumno);
		return "matricula";
	}

}
