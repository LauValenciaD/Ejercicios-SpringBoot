package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteServicio;
import com.example.demo.service.ServiceInterface;

@RestController
@RequestMapping("/clientes")
public class Controller {

	@Autowired // conectar con el autowired
	private ServiceInterface servicio; // crear una variable de la clase ClienteServicio

	@GetMapping // Mostrar todos los Clientes
	public ResponseEntity<List> getClientes() {
		List<Cliente> lista = servicio.getClientes(); // llamamos al servicio
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}") // consultar un Cliente por su titulo
	public ResponseEntity<Cliente> getTitulo(@PathVariable Integer id) {
		Cliente cliente = servicio.getCliente(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok(cliente);

	}

	@PostMapping // añadir una nueva Cliente
	public ResponseEntity<Cliente> postCliente(@RequestBody Cliente cliente) { // en el postman escribir en el body raw
																				// // los datos del cliente como en //
																				// el JSON
		servicio.insertaCliente(cliente);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}") // cuidado que ahora va con id
	public ResponseEntity<Cliente> putCliente(@RequestBody Cliente cliente, @PathVariable Integer id) { // actualizar
																										// total
		cliente.setId(id);
		Cliente encontrado = servicio.getCliente(id);

		if (encontrado == null) {
			return ResponseEntity.notFound().build();
		} else {
			servicio.actualizaCliente(cliente);
			return ResponseEntity.noContent().build();
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Cliente> patchCliente(@RequestBody Cliente cliente, @PathVariable Integer id) { // actualizar
		Cliente encontrado = servicio.getCliente(id);

		if (encontrado == null) {
			return ResponseEntity.notFound().build();
		} else {
			if (cliente.getNombre() != null) {
				encontrado.setNombre(cliente.getNombre());
			}
			if (cliente.getApellidos() != null) {
				encontrado.setApellidos(cliente.getApellidos());
			} // total
			servicio.actualizaCliente(cliente);
			return ResponseEntity.noContent().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> deleteCliente(@RequestBody Integer id) { // actualizar
		Cliente encontrado = servicio.getCliente(id);
		if (encontrado == null) {
			return ResponseEntity.notFound().build();
		} else { // total
			servicio.deleteCliente(encontrado);
			return ResponseEntity.noContent().build();
		}
	}

	/*
	 * getClientesNombre: dado un nombre, obtiene la lista de todos los clientes
	 * cuyo nombre contenga el nombre a buscar.
	 */
	@GetMapping("/{nombre}")
	public ResponseEntity<List> getClientesNombre(@RequestBody String nombre) {
		List<Cliente> lista = servicio.getClientesNombre(nombre); // llamamos al servicio
		return ResponseEntity.ok(lista);
	}
}
