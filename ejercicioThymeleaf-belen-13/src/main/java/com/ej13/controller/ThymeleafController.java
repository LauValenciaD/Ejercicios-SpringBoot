package com.ej13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ej13.model.Autor;
import com.ej13.service.AutorServiceImpl;



@Controller
public class ThymeleafController {
	
	@Autowired
	private AutorServiceImpl service;
	

	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/autores")
	public String listarempleados(Model model) {
		List<Autor> autores = service.getAllAutores();
		model.addAttribute("autores", autores);
		return "autores-lista";
	}
}
