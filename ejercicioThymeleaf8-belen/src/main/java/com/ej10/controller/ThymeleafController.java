package com.ej10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ej10.model.Empleado;
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
}
