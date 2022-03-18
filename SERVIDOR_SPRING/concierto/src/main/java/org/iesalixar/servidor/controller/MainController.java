package org.iesalixar.servidor.controller;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.dto.EntradaDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("/entradas")
	public String matricula(Model model) {

		List<String> grupos = new ArrayList<>();

		grupos.add("SFDK");
		grupos.add("Natos y Waor");
		grupos.add("DUO KIE");

		model.addAttribute("entrada", new EntradaDTO());

		return "forms/entrada";
	}

	@PostMapping("/entradas")
	public String matricula(@ModelAttribute EntradaDTO entrada, Model model) {

		model.addAttribute("entrada", entrada);
		return "forms/entrada";
	}

}
