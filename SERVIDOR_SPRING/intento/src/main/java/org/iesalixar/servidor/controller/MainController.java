package org.iesalixar.servidor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String inicio(Model model) {
		model.addAttribute("CONTENIDO", "inicio");
		return "index";
	}
	
	
}
