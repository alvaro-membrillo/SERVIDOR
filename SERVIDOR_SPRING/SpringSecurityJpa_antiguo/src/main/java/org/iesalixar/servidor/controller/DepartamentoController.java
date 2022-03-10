package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.dto.DepartamentoDTO;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImpl departamentoService;

	@Autowired
	ProfesorServiceImpl profesorService;

	@RequestMapping("/departments")
	public String products(Model model) {

		List<Departamento> departamentos = departamentoService.getAllDepartments();

		model.addAttribute("contenido", "DEPARTAMENTOS");
		model.addAttribute("departamentos", departamentos);
		return "departments";
	}

	@GetMapping("/departments/add")
	public String addDepartmentGet(@ModelAttribute DepartamentoDTO dpto, Model model) {
		model.addAttribute("dpto", dpto);
		return "addDepartment";
	}

	@PostMapping("/departments/add")
	public String addDepartmentPost(@ModelAttribute DepartamentoDTO dpto, Model model) {

		Departamento dptoBD = new Departamento();
		dptoBD.setNombre(dpto.getNombre());

		if (departamentoService.insertaDepartamento(dptoBD) == null) {
			return "redirect:/departments/add";
		}

		return "redirect:/departments";
	}

	@GetMapping("/departments/edit")
	public String editDpto(@RequestParam(name = "dpto") String dpto, Model model) {

		Departamento department = departamentoService.findDepartamentoById(Long.parseLong(dpto));
		model.addAttribute("department", department);
		return "editDepartament";
	}

	@PostMapping("/departments/edit")
	public String updateDpto(@ModelAttribute Departamento dpto) {
		if (departamentoService.actualizarDepartamento(dpto) == null) {
			return "redirect:/departments/edit?error=error&dpto" + dpto.getId();
		}
		return "redirect:/departments";
	}

	@GetMapping("/departments/profesores")
	public String profesoresDepartamento(@RequestParam(required = false, name = "dpto") String dpto, Model model) {

		Departamento dptoEntity = departamentoService.findDepartamentoById(Long.parseLong(dpto));

		if (dpto == null || dptoEntity == null) {
			return "redirect:/departamentos";
		}

		model.addAttribute("departamento", dptoEntity);
		return "profesoresDepartamento";
	}
	
	@GetMapping("/departments/profesor/delete")
	public String borrarProfesorDepartamento (@RequestParam(required=false, name="prof") String prof, Model model) {
		
		Profesor profEntity = profesorService.findProfesorById(Long.parseLong(prof)).get();
		Long dptoId = profEntity.getDepartamento().getId();
		
		profesorService.actualizarProfesor(profEntity);
		
		return "redirect:/departments/profesores?dpto="+dptoId;
	}

}


