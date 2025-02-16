package com.ej13.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ej13.model.Autor;
import com.ej13.model.Libro;
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
	public String listarautors(Model model) {
		List<Autor> autores = service.getAllAutores();
		model.addAttribute("autores", autores);
		return "autores-lista";
	}

	@GetMapping("/autor-form")
	public String formulario(Model model) {
		model.addAttribute("autor", new Autor());
		return "autor-form";
	}

	@PostMapping("/autor-form")
	public String submitFormulario(@ModelAttribute Autor autor, Model model) {
		service.addAutor(autor);
		return "redirect:/autores"; // redirige a los autors
	}

	@GetMapping("/libro-form")
	public String formularioOfi(Model model) {
		model.addAttribute("libro", new Libro());
		List<Autor> autores = service.getAllAutores();
		model.addAttribute("autores", autores);
		return "libro-form";
	}

	@PostMapping("/libro-form")
	public String submitFormularioOfi(@RequestParam(name = "autorChecked", required = false) Integer id,
			@ModelAttribute Libro libro, Model model) {
		if (id != null) {
			Autor autor = service.getAutorById(id);
			libro.setAutor(autor);
			service.addLibroToAutor(id, libro);
		}

		return "redirect:/autores"; // redirige
	}
	@GetMapping("/buscar-autor")
	public String buscarPornombre(@RequestParam(name = "nombre", required = false) String nombre, Model model) { //como es un string usamos request Param
			List<Autor> autores = new ArrayList<>();
			if(nombre != null && !nombre.isEmpty()){
			autores = service.getAutoresByNombreContaining(nombre);
			}
			model.addAttribute("autores", autores);
			model.addAttribute("nombre", nombre);
			return "buscar-autor"; //redirige a la vista e imprime los autores de la nombre
		}

}
