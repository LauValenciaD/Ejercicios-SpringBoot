package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;
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
	@GetMapping("/cursos/listado")
	public String listaCursos(Model model) {
	List<Curso> cursos = serviceCurso.getAll();
	model.addAttribute("cursos", cursos);
	return "cursos-lista";
	}
	@GetMapping("/cursos/crear")
	 public String form(Model model) {
	model.addAttribute("curso", new Curso());
	 return "curso-form"; 
	}
	@PostMapping("/cursos/guardar")
	public String submitForm(@ModelAttribute Curso curso, Model model) {
		serviceCurso.insert(curso);
		return "redirect:/cursos/listado";
	}
	@GetMapping("/estudiantes/crear")
	 public String formEstudiante(Model model) {
	model.addAttribute("estudiante", new Estudiante());
	List<Curso> cursos = serviceCurso.getAll();
	model.addAttribute("cursos", cursos);
	 return "estudiante-form"; 
	}
	@PostMapping("/estudiantes/crear")
	public String submitFormEstudiante(@RequestParam(name = "cursoChecked", required = false) Integer id, @ModelAttribute Estudiante estudiante, Model model) {
		Curso curso = serviceCurso.getId(id);
		curso.addEstudiante(estudiante);
		serviceCurso.insert(curso); //hace merge y se propaga
		return "redirect:/cursos/listado";
	}
	@GetMapping("/estudiantes/buscar")
	public String buscarPornombre(@RequestParam(name = "nombre", required = false) String nombre, Model model) { //como es un string usamos request Param
			List<Estudiante> estudiantes = new ArrayList<>();
			if(nombre != null){
			estudiantes = serviceEstudiante.containsPalabra(nombre);
			}
			model.addAttribute("estudiantes", estudiantes);
			model.addAttribute("nombre", nombre);
			return "buscar-estudiante"; //redirige a la vista e imprime los estudiantes de la nombre
		}


}