package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.dto.AlumnoAsignaturaDTO;
import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.AlumnoAsignatura;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.services.AlumnoAsignaturaServiceImpl;
import org.iesalixar.servidor.services.AlumnoServiceImpl;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {

	@Autowired
	AlumnoAsignaturaServiceImpl aaService;

	@Autowired
	AlumnoServiceImpl alumService;

	@Autowired
	AsignaturaServiceImpl asigService;

	@RequestMapping("/add")
	public String addMatricula(@RequestParam(required = false, name = "error") String error,
			@RequestParam(name = "codigo") String codigo, Model model) {

		Asignatura asignatura = asigService.findAsignaturaById(Long.parseLong(codigo));
		model.addAttribute("asignatura", asignatura);

		AlumnoAsignaturaDTO alumAsigDTO = new AlumnoAsignaturaDTO();
		List<Alumno> alumnos = alumService.getAllAlumnos();
		List<Asignatura> asignaturas = asigService.getAllAsignaturas();

		model.addAttribute("alumAsigDTO", alumAsigDTO);
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("asignaturas", asignaturas);
		model.addAttribute("error", error);

		return "addMatricula";
	}

	@PostMapping("/add")
	public String addMatriculaPost(@ModelAttribute AlumnoAsignaturaDTO alumAsigDTO, Model model) {

		AlumnoAsignatura alumAsig = new AlumnoAsignatura();
		alumAsig.setAlumno(alumAsigDTO.getId_alumno());
		alumAsig.setAsignatura(alumAsigDTO.getId_asignatura());
		alumAsig.setNota(alumAsigDTO.getNota());

		if (aaService.insertarAa(alumAsig) == null) {
			return "redirect:/matricula/add?error=Existe&grado" + alumAsigDTO.getId_asignatura().getId();
		}

		return "redirect:/";
	}

	@RequestMapping("/list")
	public String listMatricula(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "codigo") String codigo, Model model) {

		if (codigo == null) {
			return "redirect:/";
		}

		Asignatura asignatura = asigService.findAsignaturaById(Long.parseLong(codigo));
		model.addAttribute("asignatura", asignatura);

		if (asignatura.getAlumnosAsignatura().size() == 0 || asignatura == null) {
			error = "error";
			model.addAttribute("error", error);
		}

		return "listaMatricula";
	}

	@RequestMapping("/list/delete")
	public String asignaturaAlumnoDelete(@RequestParam(required = true, name = "asig") String asig,
			@RequestParam(required = true, name = "alum") String alum) {

		Asignatura asignatura = asigService.findAsignaturaById(Long.parseLong(asig));

		if (asignatura != null) {
			Alumno alumno = alumService.findAlumnoById(Long.parseLong(alum)).get();
			asignatura.removeNota(alumno);
			asigService.actualizarAsignatura(asignatura);
			return "redirect:/matricula/list?codigo=" + asig;
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping("/report")
	public String reportMatricula(@RequestParam(required=false, name="error") String error, @RequestParam(name = "codigo") String codigo, Model model) {
//		AlumnoAsignaturaDTO alumAsigDTO = new AlumnoAsignaturaDTO();
		
		Asignatura asignatura = asigService.findAsignaturaById(Long.parseLong(codigo));
		model.addAttribute("asignatura", asignatura);
		
		return "reportMatricula";
	}

}
