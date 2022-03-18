package org.iesalixar.servidor.controller;

import java.util.Optional;

import org.iesalixar.servidor.dto.GradoDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.GradoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradoController {

	@Autowired
	GradoServiceImpl gradoService;
	
	@Autowired
	AsignaturaServiceImpl asignaturaService;

	@RequestMapping("/grados") 
	public String grados(Model model) {

		model.addAttribute("contenido", "GRADOS");
		return "grados";
	}

	@GetMapping("/grados")
	public String mostrarGrados(Model model) {

		model.addAttribute("grados", gradoService.getAllGrados());

		return "grados";
	}

	@GetMapping("/grados/asignaturas")
	public String mostrarAsignaturas(@RequestParam(required = false, name = "codigo") String codigo, Model model) {

		// Obtengo el parámetro de la URL (en caso de no esta vuelvo a la lista de asignaturas
		if (codigo == null) {
			
			model.addAttribute("error", "No ha sido posible encontrar el codigo del grado");
			return "redirect:/grados";
			
		}

		Optional<Grado> grado = gradoService.findGradoById(Long.parseLong(codigo));
		model.addAttribute("grado", grado.get());
		
		return "gradosAsignaturas";

	}
	
	@RequestMapping("/grados/addGrado")
	public String addGradoR(Model model) {

		model.addAttribute("contenido", "GRADOS");
		return "addGrados";
	}
	
	@GetMapping("/grados/addGrado")
	public String addGrado(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="grado") String nombre,
			Model model) {

		GradoDTO grado = new GradoDTO(); 
		
		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		model.addAttribute("contenido", "Añadir Grado");
		
		return "addGrados";

	}
	
	@PostMapping("/grados/addGrado")
	public String addGradoPost(@ModelAttribute GradoDTO grado,Model model) {
		
		Grado gradoBD = new Grado();
		gradoBD.setNombre(grado.getNombre());
		
		if (gradoService.insertarGrado(gradoBD) == null) {
			
			return "redirect:/grados/addGrado?error=Existe&grado="+ grado.getNombre();
			
		}
		
		return "redirect:/grados/addGrado";
	}
	
	@GetMapping("/grados/asignaturas/delete")
	public String borrarAsignaturaGrado(@RequestParam(required = false, name = "codigo") String codigo, Model model) {

		Asignatura asigEntity = asignaturaService.findAsignaturaById(Long.parseLong(codigo)).get();
		Long asigId = asigEntity.getGrado().getId();

		asigEntity.setGrado(null);

		asignaturaService.actualizarAsignatura(asigEntity);

		return "redirect:/grados/asignaturas?codigo=" + asigId;

	}
	
}
