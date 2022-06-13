package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.AsignaturaDTO;
import org.iesalixar.servidor.dto.ProfesorAsignaturaDTO;
import org.iesalixar.servidor.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
import org.iesalixar.servidor.services.ProfesorService;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfesorController {

	@Autowired
	ProfesorServiceImpl profesorService;

	@Autowired
	DepartamentoServiceImpl departamentoService;

	@Autowired
	AsignaturaServiceImpl asignaturaService;

	@RequestMapping("/profesores")
	public String mostrarProfesores(Model model) {

		List<Profesor> profesores = profesorService.getAllProfesores();
		model.addAttribute("profesores", profesores);

		return "profesores";
	}

	@RequestMapping("/profesores/asignaturas")
	public String profesorAsignaturas(@RequestParam(required = false, name = "prof") String prof, Model model) {

		Optional<Profesor> profesores = profesorService.findProfesorById(Long.parseLong(prof));

		if (prof == null || profesores == null) {
			model.addAttribute("error", "PROFESOR NO SELECCIONADO o PROFESOR SIN ASIGNATURAS ASIGNADAS");
			return "redirect:/";
		}

		model.addAttribute("error", null);
		model.addAttribute("profesores", profesores.get());

		return "profesorAsignaturas";
	}

	@RequestMapping("/profesores/addProfesor")
	public String addProfesor(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "prof") String nombre, Model model) {

		ProfesorDTO profesorDTO = new ProfesorDTO();

		List<Departamento> departamentos = departamentoService.getAllDepartamentos();
		model.addAttribute("prof", profesorDTO);
		model.addAttribute("departamentos", departamentos);
		model.addAttribute("error", error);

		return "addProfesor";
	}

	@PostMapping("/profesores/addProfesor")
	public String addProfesorPost(@ModelAttribute ProfesorDTO profDTO, Model model) {

		if (profesorService.findProfesorByNif(profDTO.getNif()) == null) {
			Profesor prof = new Profesor();
			prof.setNif(profDTO.getNif());
			prof.setNombre(profDTO.getNombre());
			prof.setApellido1(profDTO.getApellido1());
			prof.setApellido2(profDTO.getApellido2());
			prof.setCiudad(profDTO.getCiudad());
			prof.setDireccion(profDTO.getDireccion());
			prof.setFechaNacimiento(profDTO.getFechaNacimiento());
			prof.setSexo(profDTO.getSexo());
			prof.setTelefono(profDTO.getTelefono());
			prof.setDepartamento(departamentoService.findDepartamentoById((long) profDTO.getId_departamento()));

			if (profesorService.insertarProfesor(prof) == null) {
				return "redirect:/profesores/addProfesor?error=Existe&prof=" + profDTO.getNombre();
			}
		} else {
			return "redirect:/profesores/addProfesor?error=ExisteNif&prof=" + profDTO.getNif();
		}

		return "redirect:/profesores/";
	}

	@RequestMapping("/profesores/asignarAsignatura")
	public String asignarAsignatura(@RequestParam(required=false,name="error") String error, @RequestParam(required=false, name="idAsignatura") String idAsignatura, 
			@RequestParam(required=false, name="nifProfesor") String nif, Model model) {
		
		ProfesorAsignaturaDTO profesorAsignatura = new ProfesorAsignaturaDTO();
		List<Asignatura> asignaturas = asignaturaService.getAllAsignaturas();
		List<Profesor> profesores = profesorService.getAllProfesores();
		
		model.addAttribute("profesorAsignatura", profesorAsignatura);
		model.addAttribute("asignaturas", asignaturas);
		model.addAttribute("profesores", profesores);
		model.addAttribute("error", error);

		return "asignarAsignatura";
	}

	@PostMapping("/profesores/asignarAsignatura")
	public String asignarAsignaturaPost(@ModelAttribute ProfesorAsignaturaDTO profesorAsignatura, Model model) {
		
		Asignatura asignatura = asignaturaService.findAsignaturaById(Long.parseLong(profesorAsignatura.getIdAsignatura()));
		Profesor profesor = profesorService.findProfesorByNif(profesorAsignatura.getNifProfesor());
				
		if (asignatura != null && profesor != null) {
			asignatura.setProfesor(profesor);
			asignaturaService.actualizarAsignatura(asignatura);
			
			return "redirect:/profesores/asignaturas?prof="+asignatura.getProfesor().getId();
		}
		
		return "redirect:/profesores/asignarAsignatura";
	}

}
