package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ejercicio2.Alumno;

@RestController
@RequestMapping("/clientes")
public class Controladores2 {
	private ArrayList<Alumno> listaClientes = new ArrayList<>();

	public Controladores2() {
		Alumno cliente1 = new Alumno("1", "Juan", "juanito", "1234");
		Alumno cliente2 = new Alumno("2", "Pepe", "pepito", "1234");
		Alumno cliente3 = new Alumno("3", "Maria", "maria", "1234");
		Alumno cliente4 = new Alumno("4", "Carmen", "carmencita", "1234");

		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
		listaClientes.add(cliente3);
		listaClientes.add(cliente4);
	}

	@GetMapping("validar-palindromo/{palabra}")
	public String palindromoVer(@PathVariable String palabra) {
		palabra = palabra.toLowerCase(); // ejercicio 1
		String invertida = new StringBuilder(palabra).reverse().toString(); //le da la vuelta
		if (palabra.equals(invertida)) {
			return "La palabra es palindroma";
		} else {
			return "La palabra no es palindroma";
		}
	}

	@GetMapping //borrado (/clientes)
	public ArrayList verClientes() {
		return listaClientes;
	}

	@GetMapping("/{username}") // ejercicio 2
	public Alumno getInfo(@PathVariable String username) {
		for (Alumno cliente : listaClientes) { //hacer un for each para ver todos los datos del cliente
			if (cliente.getUsername().equalsIgnoreCase(username)) //si coincide devuelve el cliente
			{
				return cliente;
			}
		}
		System.out.println("No se encontró el cliente");
		return null;
	}
	@PostMapping //añadir un nuevo cliente a la lista de clientes
	public Alumno postClientes(@RequestBody Alumno cliente) { //en el postman escribir en el body raw los datos del cliente como en el JSON
		listaClientes.add(cliente);
		return cliente;
	}
	@PutMapping("/{id}")
	public Alumno putCliente (@RequestBody Alumno cliente, @PathVariable String id) //busca a un cliente por id y lo actualiza
	{
		for (Alumno cliente1 : listaClientes) { //hacer un for each para ver todos los datos del cliente
			if (cliente1.getId().equalsIgnoreCase(id)) //si coincide devuelve el cliente
			{
				cliente1.setNombre(cliente.getNombre());
				cliente1.setPassword(cliente.getPassword());
				cliente1.setUsername(cliente.getUsername());
				return cliente1;
			}
		}
		System.out.println("No se encontró el cliente");
		return null;
	}
	@DeleteMapping("/{id}")
	public Alumno deleteCliente (@PathVariable String id)
	{
	Iterator<Alumno> iterator = listaClientes.iterator(); //para borrar NO usar for each porque puede dar error
	while (iterator.hasNext())
	{ Alumno cliente = iterator.next();
	if (cliente.getId().equalsIgnoreCase(id))
	{
		iterator.remove();
		return cliente;
			}
		}
		System.out.println("No se encontró el cliente");
		return null;
	}
}
