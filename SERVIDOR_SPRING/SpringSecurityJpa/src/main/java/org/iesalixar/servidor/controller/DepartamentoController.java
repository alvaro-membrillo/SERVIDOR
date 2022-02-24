package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.DepartamentoDTO;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
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
	
	@RequestMapping("/departments")
	public String products(Model model) {
		
		List<Departamento> departamentos = departamentoService.getAllDepartments();
		
		model.addAttribute("contenido","DEPARTAMENTOS");
		model.addAttribute("departamentos",departamentos);
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
	
	@GetMapping("/departaments/profesores")
	public String profesoresDepartamento(@RequestParam(name="id_departamento") String id_departamento, Model model) {
		
		if (id_departamento == null) {
			return "redirect:/departamentos";
		}
		
		Optional<Departamento> departamento = departamentoService.findDepartamentoById(Long.parseLong(id_departamento));
		model.addAttribute("departamento", departamento.get());
		return "profesoresDepartamento";
	}
	
	@GetMapping("/departments/edit")
	public String editDpto(@RequestParam(name="dpto") String dpto, Model model) {
		Departamento department = departamentoService.findDepartamentoById(Long.parseLong(dpto));
		model.addAttribute("department", department);
		return "editDepartament";
	}
	
	@PostMapping("/departments/edit")
	public String updateDpto(@ModelAttribute Departamento dpto) {
		if (departamentoService.actualizarDepartamento(dpto) == null) {
			return "redirect:/departments/edit?error=error&dpto"+dpto.getId();
		}
		return "redirect:/departments";
	}
	
}
