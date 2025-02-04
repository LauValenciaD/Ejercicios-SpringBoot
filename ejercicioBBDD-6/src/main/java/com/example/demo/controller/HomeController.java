package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Cliente;
import com.example.demo.service.ServiceInterface;

@Controller
public class HomeController {
	
	@Autowired
	private ServiceInterface clienteService;


	    @GetMapping("/clientes")
	    public String listarClientes(Model model) {
	        List<Cliente> clientes = clienteService.getClientes();
	        model.addAttribute("clientes", clientes);
	        return "index";
	    }
	    @GetMapping("/clientes/{id}")
	    public String verCliente(@PathVariable Integer id, Model model) {
	        Cliente cliente = clienteService.getCliente(id);
	        if (cliente == null) {
	            return "redirect:/clientes"; // Redirige si el cliente no existe
	        }
	        model.addAttribute("cliente", cliente);
	        return "detalle"; // Nombre de la nueva vista
	    }

}
