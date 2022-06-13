package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@RequestMapping("/usuarios")
	public String home(Model model) {
		
		List<Usuario> usuarios = usuarioService.getAllUsuarios();
		model.addAttribute("usuarios", usuarios);
		
		return "usuarios";
	}
	
	@PostMapping("/usuarios/delete")
	public String deleteUsuario(@RequestParam(required=false, name="usuario") String usuario, Model model) {
		
		Usuario user = usuarioService.findUsuarioById(Long.parseLong(usuario)).get();
		
		if (user!=null) {
			
		}
		
		return "usuarios";
	}
	
}
