package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.dto.GradoDTO;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.GradoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradoController {
	
	@Autowired
	GradoServiceImpl gradoService;
	
	@Autowired
	AsignaturaServiceImpl asignaturaService;
	
	@GetMapping("/grados")
	public String grados(Model model) {
		
		List<Grado> grados = gradoService.getAllGrados();
		
		model.addAttribute("grados", grados);
		return "grados";
	}
	
	@GetMapping("/grados/addGrado")
	public String addGrados(@RequestParam(required=false, name="error") String error, @ModelAttribute GradoDTO grado, Model model) {
		
		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		return "addGrado";
	}
	
	@PostMapping("/grados/addGrado")
	public String addGradosPost(@ModelAttribute GradoDTO gradoDTO, Model model) {
		
		Grado gradoBD = new Grado();
		gradoBD.setNombre(gradoDTO.getNombre());
		
		if (gradoService.insertaGrado(gradoBD) == null) {
			List<Grado> gradosInsertados = gradoService.getAllGrados();
			
			return "redirect:/grados/addGrado?error=Existe&grado"+gradoDTO.getNombre();
		}
		
		return "redirect:/grados";
	}
	
	@GetMapping("/grados/asignaturas")
	public String asignaturas(@RequestParam(required=false, name="codigo") String codigo, Model model) {
		
		if (codigo == null) {
			return "redirect:/asignaturasGrado";
		}	
		
		/*Optional<Asignatura> asignaturas = asignaturaService.findAsignaturaById();
		model.addAttribute("asignatura",asignatura.get());*/
		
		return "asignaturasGrado";
	}
	
	
}
