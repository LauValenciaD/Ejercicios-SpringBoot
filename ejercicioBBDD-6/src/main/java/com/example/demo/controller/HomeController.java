package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Cliente;
import com.example.demo.service.ClienteServicio;

@Controller
@RequestMapping("/clientes")
public class HomeController {

	@Autowired
	private ClienteServicio clienteService;

	@GetMapping
	public String listarClientes(Model model) {
		List<Cliente> clientes = clienteService.getClientes();
		model.addAttribute("clientes", clientes);
		return "index";
	}

	@GetMapping("/{id}")
	public String verCliente(@PathVariable Integer id, Model model) {
		Cliente cliente = clienteService.getCliente(id);
		if (cliente == null) {
			return "redirect:/clientes"; // Redirige si el cliente no existe
		}
		model.addAttribute("cliente", cliente);
		return "detalle"; // Nombre de la nueva vista
	}

	@GetMapping("/formulario")
	public String formulario(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "formulario";
	}

	@PostMapping("/formulario")
	public String submitFormulario(@ModelAttribute Cliente cliente, Model model) {
		clienteService.insertaCliente(cliente);
		return "redirect:/clientes"; //redirige a los clientes
	}
	
	@GetMapping("/ciudad")
	public String ciudad(Model model) {
		model.addAttribute("clientes", new ArrayList<>()); // Lista vacía al inicio
		return "ciudad";
	}
	@PostMapping("/ciudad")
	public String submitCiudad(@RequestParam("ciudad") String ciudad, Model model) { //como es un string usamos request Param
		List<Cliente> clientes = clienteService.getClientesCiudad(ciudad);
		model.addAttribute("clientes", clientes);
		model.addAttribute("ciudad", ciudad);
		return "ciudad"; //redirige a los clientes
	}

}
