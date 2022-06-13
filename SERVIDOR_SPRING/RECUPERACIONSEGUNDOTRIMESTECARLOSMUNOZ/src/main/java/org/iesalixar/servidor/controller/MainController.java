package org.iesalixar.servidor.controller;

import org.iesalixar.servidor.dto.UsuarioDTO;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
//	@RequestMapping("/")
//	public String home(Model model) {
//		model.addAttribute("contenido", "INICIO");
//		
//		return "index";
//	}
	
//	@RequestMapping("/register")
//	public String register(Model model) {
//		UsuarioDTO userDTO = new UsuarioDTO();
//		model.addAttribute("usuario", userDTO);
//		return "register";
//	}
//	
//	@PostMapping("/register")
//	private String register(@ModelAttribute UsuarioDTO usuario) {
//		
//		Usuario user = new Usuario();
//		user.setActivo(true);
//		user.setNombre(usuario.getNombre());
//		user.setApellidos(usuario.getApellidos());
//		user.setUserName(usuario.getUsuario());
//		user.setRole("ROLE_USER");
//		user.setEmail(usuario.getEmail());
//		user.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));
//		
//		user = usuarioService.insertUsuario(user);
//		
//		if (user==null) {
//			return "redirect:/register";
//		}
//		
//		return "redirect:/";
//	}
	
}
