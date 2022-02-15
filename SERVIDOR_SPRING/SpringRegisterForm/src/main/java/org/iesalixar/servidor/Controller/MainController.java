package org.iesalixar.servidor.Controller;

import org.iesalixar.servidor.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forms")
public class MainController {

	@RequestMapping("/registerForm")
	public String showRegisterForm(Model model) {

		UserDTO user = new UserDTO();
		model.addAttribute("user", user);

		return "forms/registerForm";
	}

	@PostMapping("/registerForm")
	public String registerFormPost(@ModelAttribute UserDTO user, Model model) {
		model.addAttribute("user", user);
		return "forms/registerForm";

	}

}
