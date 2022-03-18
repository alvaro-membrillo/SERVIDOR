package org.iesalixar.servidor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("contenido", "INICIO");
		return "index";
	}

	@RequestMapping("/products")
	public String products(@RequestParam(name = "product", required = false, defaultValue = "Café") String product,
			@RequestParam(name = "brand", required = false, defaultValue = "Saimaza") String brand,
			@RequestParam(name = "category", required = false, defaultValue = "Colombia") String category,
			Model model) {

		model.addAttribute("contenido", "PRODUCTS");
		model.addAttribute("product", product);
		model.addAttribute("brand", brand);
		model.addAttribute("category", category);

		return "products";
	}

	@RequestMapping("/services")
	public String services(@RequestParam(name = "services", required = false, defaultValue = "Chef") String services,
			@RequestParam(name = "category", required = false, defaultValue = "reposteria") String category,
			Model model) {
		model.addAttribute("contenido", "SERVICES");
		model.addAttribute("services", services);
		model.addAttribute("category", category);
		return "services";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("contenido", "ABOUT");
		return "about";
	}

}
