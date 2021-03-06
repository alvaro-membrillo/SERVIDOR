package org.iesalixar.servidor.controller;

import org.iesalixar.servidor.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("contenido", "INICIO");
		return "index";
	}
	
}
