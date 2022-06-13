package org.iesalixar.servidor.controller;

<<<<<<< HEAD
=======
import java.text.ParseException;
>>>>>>> b835d2b80e7acb142e536d7e349fda30f057e9aa
import java.util.List;

import org.iesalixar.servidor.dto.AsignaturaProfesorDTO;
import org.iesalixar.servidor.dto.ProfesorDTO;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.AsignaturaServiceImpl;
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
public class ProfesorController {

	@Autowired
	DepartamentoServiceImpl departamentoService;
	
	@Autowired
	AsignaturaServiceImpl asignaturaService;

	@Autowired
	ProfesorServiceImpl profesorService;

	@RequestMapping("/profesores")
	public String profesores(Model model) {

		List<Profesor> profesores = profesorService.getAllProfesores();
		model.addAttribute("contenido", "Profesores");
		model.addAttribute("profesores", profesores);
		return "profesores";
		/*
		 * List<Departamento> departamentos = departamentoService.getAllDepartments();
		 * 
		 * model.addAttribute("contenido", "PRODUCTOS");
		 * model.addAttribute("departamentos", departamentos); return "departments";
		 */
	}

	@GetMapping("/profesores/addProfesor")
	public String addProfesorGet(@RequestParam(required = false, name = "error") String error,
			@RequestParam(required = false, name = "profesor") String nombre, Model model) {

		ProfesorDTO profe = new ProfesorDTO();

		model.addAttribute("profe", profe);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		model.addAttribute("departamento", departamentoService.getAllDepartments()); //Todos los departamentos
		
		return "addProfesor";
	}

	@PostMapping("/profesores/addProfesor")
<<<<<<< HEAD
	public String addProfesorPost(@ModelAttribute ProfesorDTO profe, Model model) {
=======
	public String addProfesorPost(@ModelAttribute ProfesorDTO profe, Model model) throws ParseException {
>>>>>>> b835d2b80e7acb142e536d7e349fda30f057e9aa
		
		Profesor profeBD = new Profesor();
		profeBD.setNif(profe.getNif());
		profeBD.setNombre(profe.getNombre());
		profeBD.setApellido1(profe.getApellido1());
		profeBD.setApellido2(profe.getApellido2());
		profeBD.setCiudad(profe.getCiudad());
		profeBD.setDireccion(profe.getDireccion());
		profeBD.setFechaNacimiento(profe.getFechaNacimiento());
		profeBD.setSexo(profe.getSexo());
		
		Departamento departamentos = departamentoService.findDepartamentoById(profe.getDepartamento());
<<<<<<< HEAD
=======
		//Departamento departamentos = departamentoService.findDepartamentoById(profe.getDepartamento());
>>>>>>> b835d2b80e7acb142e536d7e349fda30f057e9aa
		profeBD.setDepartamento(departamentos);

		if (profesorService.insertarProfesor(profeBD) == null) {
			return "redirect:/profeso	res/addProfesor?error=Existe&dpto=" + profe.getNombre();
		}

		return "redirect:/profesores";
	}

	/*@GetMapping("/departments/edit")
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
	}*/

	@GetMapping("/profesores/asignaturas")
	public String profesoresDepartamento(@RequestParam(required = false, name="error") String error, @RequestParam(required = false, name = "codigo") String codigo, Model model) {


		if (codigo == null || codigo == "") {
			
			model.addAttribute("error", "Profesor no seleccionado");
			
			return "redirect:/profesores";
		}
		
		Profesor profEntity = profesorService.findProfesorById(Long.parseLong(codigo));

		model.addAttribute("asignatura", profEntity);

		return "profesoresAsignaturas";
	}

	/*@GetMapping("/departments/profesor/delete")
	public String borrarProfesorDepartamento(@RequestParam(required = false, name = "prof") String prof, Model model) {

		Profesor profEntity = profesorService.findProfesorById(Long.parseLong(prof)).get();
		Long dptoId = profEntity.getDepartamento().getId();

		profEntity.setDepartamento(null);

		profesorService.actualizarProfesor(profEntity);

		return "redirect:/departments/profesores?dpto=" + dptoId;

	}
	
	@GetMapping("/departments/addProfesor")
	public String addProfesorDepartmentoGet(Model model) {
		// MODEL ES PARA PASAR A LA VISTA, NO PARA RECOGER
		// Hay que pasarle un objeto vacio
		ProfesorDepartamentoDTO dto = new ProfesorDepartamentoDTO();

		model.addAttribute("dto", dto);
		// Le pasamos dos listas
		model.addAttribute("profesor", profesorService.findDepartamentoIsNull()); // Lista con todos los profesores que
																					// tengan departamento nulo
		model.addAttribute("departamento", departamentoService.getAllDepartments()); // Todos los departamentos

		return "addProfesorDepartment";
	}

	@PostMapping("/departments/addProfesor")
	public String addProfesorDepartmentPost(@ModelAttribute ProfesorDepartamentoDTO dto, Model model) {
		
		//Crear objeto profesor, llamando al servicio para obtener profesor por id, le pasamos el id del profesor de la vista
		Profesor profesorBD = profesorService.findProfesorById(dto.getProfesor()).get(); //Si el optional esta definido en el servicio, no hay que definirlo en el controller
		
		Departamento dpto = departamentoService.findDepartamentoById(dto.getDepartamento());
		
		profesorBD.setDepartamento(dpto);
		
		if (profesorService.insertarProfesorDepartamento(profesorBD) == null) {
			return "redirect:/departments/addProfesor?error=Existe&dpto=" + profesorBD.getNombre();
		}
		
		//Si se ha podido insertar
		return "redirect:/departments";
	}*/

	@GetMapping("/profesores/addAsignatura")
	public String addAsignaturaProfesorGet(Model model) {
		// MODEL ES PARA PASAR A LA VISTA, NO PARA RECOGER
		// Hay que pasarle un objeto vacio
		AsignaturaProfesorDTO dto = new AsignaturaProfesorDTO();

		model.addAttribute("dto", dto);
		// Le pasamos dos listas
		model.addAttribute("profesor", profesorService.getAllProfesores());
		model.addAttribute("asignatura", asignaturaService.getAllAsignaturas()); // Todas las asignaturas

		return "addProfesorAsignatura";
	}

	@PostMapping("/profesores/addAsignatura")
	public String addAsignaturaProfesorPost(@ModelAttribute AsignaturaProfesorDTO dto, Model model) {
		
		//Crear objeto profesor, llamando al servicio para obtener profesor por id, le pasamos el id del profesor de la vista
		Profesor profesorBD = profesorService.findProfesorById(dto.getProfesor()); //Si el optional esta definido en el servicio, no hay que definirlo en el controller
		
		Asignatura asignatura = asignaturaService.findAsignaturaById(dto.getAsignatura());
		
		/*profesorBD.setAsignaturas(asignatura);
		
		if (profesorService.insertarProfesorAsignatura(profesorBD) == null) {
			return "redirect:/profesores/addAsignatura?error=Existe&dpto=" + profesorBD.getNombre();
		}*/
		
		//Si se ha podido insertar
		return "redirect:/profesores";
	}

}
