package org.iesalixar.servidor.controller;

import org.iesalixar.servidor.dto.UsuarioDTO;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido","INICIO");
		return "index";
	}
	
	@GetMapping("/register")
	public String registerGet(Model model) {
		
		UsuarioDTO userDTO = new UsuarioDTO();		
		model.addAttribute("usuario", userDTO);		
		return "register";
	}
	
	@GetMapping("/asignaturas")
	public String asignaturas(Model model) {
		
		model.addAttribute("asignaturas", asignaturaService.getAllAsignaturas());
		
		return "asignaturas";
	}

}
