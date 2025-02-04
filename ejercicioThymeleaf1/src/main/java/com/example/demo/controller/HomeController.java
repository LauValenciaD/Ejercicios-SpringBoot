package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
	model.addAttribute("mensaje", "Bienvenido al Home");
	model.addAttribute("nombre1", "Laura");
	model.addAttribute("nombre2", "<b>Laura</b>");
	model.addAttribute("role", "admin");
	
	ArrayList<String> personas = new ArrayList<String>();
	personas.add("Carmen");
	personas.add("Pepito");
	personas.add("Antonio");
	personas.add("Manuel");
	personas.add("Laura");
	
	model.addAttribute("personas", personas);
	return "home";
	}
	@GetMapping("/index")
	 public String index() {
	 return "index"; // Retorna la plantilla Thymeleaf "index.html"
	} 
	
	@GetMapping("/form")
	 public String form(Model model) {
	model.addAttribute("user", new User());
	 return "form"; 
	} 
	
	@PostMapping("/form")
	public String submitForm(@ModelAttribute User user, Model model) {
		model.addAttribute("mensaje", "Resultado del form");
		model.addAttribute("user", user); //pasarle el objeto
		return "result";
	}
}
