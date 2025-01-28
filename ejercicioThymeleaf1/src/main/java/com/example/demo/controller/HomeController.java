package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
	model.addAttribute("mensaje", "Bienvenido al Home");
	model.addAttribute("nombre1", "Laura");
	model.addAttribute("nombre2", "<b>Laura</b>");
	return "home";
	}

}
