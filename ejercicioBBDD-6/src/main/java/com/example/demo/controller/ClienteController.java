/* package com.example.demo.controller;

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

import com.example.demo.models.Cliente;
import com.example.demo.models.Direccion;
import com.example.demo.service.ClienteServicio;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired // conectar con el autowired
	private ClienteServicio servicio; // crear una variable de la clase ClienteServicio

	@GetMapping // Mostrar todos los Clientes
	public ResponseEntity<List> getClientes() {
		List<Cliente> lista = servicio.getClientes(); // llamamos al servicio
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}") // consultar un Cliente por su id
	public ResponseEntity<Cliente> getClienteId(@PathVariable Integer id) {
		Cliente cliente = servicio.getCliente(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok(cliente);

	}

	@PostMapping // añadir una nueva Cliente
	public ResponseEntity<Cliente> postCliente(@RequestBody Cliente cliente) { // en el postman escribir en el body raw
																				// // los datos del cliente como en //
																				// // el JSON
		servicio.insertaCliente(cliente);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}") // cuidado que ahora va con id
	public ResponseEntity<Cliente> putCliente(@RequestBody Cliente cliente, @PathVariable Integer id) { // actualizar

		if (servicio.actualizaCliente(cliente, id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();

		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Cliente> patchCliente(@RequestBody Cliente cliente, @PathVariable Integer id) { // actualizar
		if (servicio.patchCliente(cliente, id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable Integer id) { // actualizar
		if (servicio.deleteCliente(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	//buscar clientes por ciudad
	@GetMapping("/ciudad/{ciudad}")
	public ResponseEntity<List> getClientesCiudad(@PathVariable String ciudad) {
		List<Cliente> lista = servicio.getClientesCiudad(ciudad); // llamamos al servicio
		return ResponseEntity.ok(lista);
	}
	
	//Modificar la dirección de un cliente. Recibe el id del cliente y la nueva dirección.
	@PatchMapping("/{id}/direccion")
	public ResponseEntity<String> patchDireccion(@RequestBody Direccion direccion, @PathVariable Integer id) { // actualizar
		if (servicio.actualizaDireccion(direccion, id)) {
			return ResponseEntity.ok("Dirección actualizada correctamente"); //mandar mensaje
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	//Actualizar la ciudad a ‘Sevilla’ de todos los clientes cuyo nombre empiece por ‘A’ o ‘a’
	@PatchMapping("/Sevilla")
	public ResponseEntity<Cliente> cambiarSevilla() { // actualizar
		if (servicio.cambiarSevilla()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	//Crear un nuevo método similar al anterior, pero para que la ciudad y la letra de inicio sean parámetros.
	@PatchMapping("/{ciudad}/{letra}")
	public ResponseEntity<Cliente> cambiarCiudad(@PathVariable String ciudad, @PathVariable String letra) { // actualizar
		if (servicio.cambiarCiudad(ciudad, letra)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
} */
