package org.iesalixar.servidor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {

	@GetMapping("/")
	public String home() {

		return "index";
	}

	@GetMapping("/servicios")
	public String servicios() {

		return "servicios";
	}

	@GetMapping("/products")
	public String products() {

		return "productos";
	}

	@GetMapping("/about")
	public String about() {

		return "about";
	}
}
