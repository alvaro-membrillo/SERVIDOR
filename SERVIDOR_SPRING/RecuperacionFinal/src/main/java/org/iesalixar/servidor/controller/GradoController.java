package org.iesalixar.servidor.controller;

import java.util.List;
import org.iesalixar.servidor.dto.GradoAsignaturaDTO;
import org.iesalixar.servidor.dto.GradoDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Grado;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.GradoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String mostrarGrados(Model model) {

		List<Grado> grados = gradoService.getAllGrados();
		model.addAttribute("grados", grados);
		model.addAttribute("error", "");

		return "grados";
	}

	@RequestMapping("/grados/asignaturas")
	public String asignaturasGrado(@RequestParam(required = false, name = "codigo") String codigo,
			@RequestParam(required = false, name = "error") String error, Model model) {

		if (codigo == null) {
			return "redirect:/grados/";
		}
		
		Grado grado = gradoService.findGradoById(Long.parseLong(codigo));
		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		return "asignaturasGrado";
	}

	@RequestMapping("/grados/addGrado")
	public String addGradoGet(@RequestParam(required = false, name = "error") String error, Model model) {
		GradoDTO grado = new GradoDTO();

		model.addAttribute("grado", grado);
		model.addAttribute("error", error);
		return "addGrado";
	}

	@PostMapping("/grados/addGrado")
	public String addGradoPost(@ModelAttribute GradoDTO gradoDTO, Model model) {

		Grado gradoBD = new Grado();
		gradoBD.setNombre(gradoDTO.getNombre());

		if (gradoService.insertarGrado(gradoBD) == null) {
			return "redirect:/grados/addGrado?error=Existe&grado" + gradoDTO.getNombre();
		}

		return "redirect:/grados";
	}

	@RequestMapping("/grados/addasignatura")
	public String addAsignaturaGet(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "id_grado") String id_grado, Model model) {

		GradoAsignaturaDTO gradoAsignatura = new GradoAsignaturaDTO();
		List<Grado> grados = gradoService.getAllGrados();
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();

		model.addAttribute("asigGrado", gradoAsignatura);
		model.addAttribute("asignaturas", asignaturas);
		model.addAttribute("grados", grados);
		model.addAttribute("error", error);

		if (id_grado != null) {
			model.addAttribute("id_grado", id_grado);
		}

		return "addAsignatura";
	}

	@PostMapping("/grados/addasignatura")
	public String addAsignaturaPost(@ModelAttribute GradoAsignaturaDTO asigGrado, Model model) {
		Grado grado = gradoService.findGradoById(asigGrado.getId_grado());
		Asignatura asig = asignaturaService.findAsignaturaById(asigGrado.getId_asignatura()).get();

		if (grado != null && asig != null) {
			asig.setGrado(grado);
			asignaturaService.actualizarAsignatura(asig);

			return "redirect:/grados/asignaturas?codigo=" + grado.getId();
		} else {
			return "redirect:/grados/addasignatura";
		}
	}

}
