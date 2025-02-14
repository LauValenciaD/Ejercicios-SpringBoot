package com.ej10.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ej10.model.Empleado;
import com.ej10.model.Oficina;
import com.ej10.service.EmpleadoService;
import com.ej10.service.OficinaService;

@Controller
public class ThymeleafController {
	
	@Autowired
	private EmpleadoService serviceEmpl;
	
	@Autowired
	private OficinaService serviceOfi;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/empleados")
	public String listarempleados(Model model) {
		List<Empleado> empleados = serviceEmpl.findAll();
		model.addAttribute("empleados", empleados);
		return "empleados-lista";
	}
	@GetMapping("/empleado-form")
	public String formulario(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "empleado-form";
	}

	@PostMapping("/empleado-form")
	public String submitFormulario(@ModelAttribute Empleado empleado, Model model) {
		serviceEmpl.createOrUpdate(empleado);
		return "redirect:/empleados"; //redirige a los empleados
	}
	//ejercicio 11
	@GetMapping("/oficinas")
	public String listarOficinas(Model model) {
		List<Oficina> oficinas = serviceOfi.findAll();
		model.addAttribute("oficinas", oficinas);
		List<Empleado> empleados = new ArrayList<>();
		model.addAttribute("empleados", empleados);

		return "oficinas-lista";
	}
	
	//ejercicio 12
	
	@GetMapping("/oficina-form")
	public String formularioOfi(Model model) {
		model.addAttribute("oficina", new Oficina());
		List<Empleado> empleados = serviceEmpl.findAll();
		model.addAttribute("empleados", empleados);
		return "oficina-form";
	}

	@PostMapping("/oficina-form")
	public String submitFormularioOfi(@RequestParam(name="empleadoChecked", required=false) List<Integer> empleadoChecked, @ModelAttribute Oficina oficina, Model model) {
		if(empleadoChecked != null) {
		for (Integer id : empleadoChecked) {
			Empleado empleado = serviceEmpl.findById(id);
			oficina.getEmpleados().add(empleado);
		} }
		serviceOfi.createOrUpdate(oficina);
		return "redirect:/oficinas"; //redirige 
	}
	//ejercicio 13
	@GetMapping("oficinas/{id}")
	public String verEmpleados(@PathVariable Integer id, Model model) {
		List<Oficina> oficinas = serviceOfi.findAll();
		model.addAttribute("oficinas", oficinas);
		if (id != null) {
			Oficina oficina = serviceOfi.findById(id);
			model.addAttribute("empleados", oficina.getEmpleados());
		}

		return "oficinas-lista";
	}
	
}
