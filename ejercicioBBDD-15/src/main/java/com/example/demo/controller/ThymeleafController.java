package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Curso;
import com.example.demo.service.CursoServInt;
import com.example.demo.service.EstudianteServInter;



@Controller
public class ThymeleafController {

	@Autowired
	private CursoServInt serviceCurso;
	
	@Autowired
	private EstudianteServInter serviceEstudiante;

	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("cursos/listado")
	public String listaCursos(Model model) {
	List<Curso> cursos = serviceCurso.getAll();
	model.addAttribute("cursos", cursos);
	return "cursos-lista";
	}
}