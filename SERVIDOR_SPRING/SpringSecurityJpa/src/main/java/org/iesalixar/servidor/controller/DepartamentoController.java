package org.iesalixar.servidor.controller;

import java.util.List;

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
	public String addDepartmentGet(Model model) {
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
	
}
