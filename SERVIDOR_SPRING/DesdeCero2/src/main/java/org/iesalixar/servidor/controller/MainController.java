package org.iesalixar.servidor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {
	
	public String home(Model model) {
		return "index";
	}
	
}
