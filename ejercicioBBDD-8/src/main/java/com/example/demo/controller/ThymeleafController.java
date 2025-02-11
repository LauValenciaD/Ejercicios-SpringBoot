package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Usuario;
import com.example.demo.service.ServiceInterface;

@Controller
public class ThymeleafController {

	@Autowired
	private ServiceInterface service;

	@GetMapping("/usuarios")
	public String listarUsuarios(Model model) {
		List<Usuario> usuarios = service.getUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "usuarios";
	}

	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	@GetMapping("/usuario-form")
	public String formulario(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("hayUsuario", false);
		return "usuario-form";
	}

	@PostMapping("/usuario-form")
	public String submitFormulario(@ModelAttribute Usuario usuario, Model model) {
		service.insertaUsuario(usuario);
		return "redirect:/usuarios"; //redirige a los usuarios
	}
	@GetMapping("/usuario-form/{id}")
	public String verUsuario(@PathVariable Integer id, Model model) {
		Usuario usuario = service.getUsuario(id);
		model.addAttribute("usuario", usuario);
		return "usuario-form"; // Nombre de la nueva vista
	}
	@GetMapping("/primerUsuario")
	public String primerUsuario(Model model) {
		Usuario usuario = service.obtenerDisponible();
		if (usuario == null) {
			model.addAttribute("hayUsuario", false);
			return "primerUsuario";
		}
		model.addAttribute("usuario", usuario);
		model.addAttribute("hayUsuario", true);
		return "primerUsuario";
	}
	
}
