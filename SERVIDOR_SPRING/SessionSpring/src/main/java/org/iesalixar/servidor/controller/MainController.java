package org.iesalixar.servidor.controller;

import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dto.UsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String inicio(Model model) {
		
		model.addAttribute("usuario", new UsuarioDTO());
		
		return "index";
	}
	
	@PostMapping("/")
	public String doLogin(@ModelAttribute UsuarioDTO usuario, Model model, HttpSession session) {
		
		if (usuario.getUsername().equals("usuario") && usuario.getPassword().equals("password")) {
			session.setAttribute("role", "usuario");
			return "redirect:/home/usuario";
		} else if (usuario.getUsername().equals("admin") && usuario.getPassword().equals("admin")) {
			session.setAttribute("role", "admin");
			return "redirect:/home/admin";
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/home/usuario")
	public String homeUsuario(ModelMap model, HttpSession session) {
		
		if (session.isNew() || !session.getAttribute("role").equals("usuario")) {
			session.invalidate();
			return "redirect:/";
		}
		return "usuario";
	}
	
	@GetMapping("/home/admin")
	public String homeAdmin(HttpSession session) {
		
		if (session.isNew() || !session.getAttribute("role").equals("admin")) {
			session.invalidate();
			return "redirect:/";
		}
		
		return "admin";
	}


}
