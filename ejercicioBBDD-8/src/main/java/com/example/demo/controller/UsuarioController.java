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

import com.example.demo.models.Usuario;
import com.example.demo.service.ServicioUsuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired // conectar con el autowired
	private ServicioUsuario servicio; // crear una variable de la clase UsuarioServicio

	@GetMapping // Mostrar todos los Usuarios
	public ResponseEntity<List> getUsuarios() {
		List<Usuario> lista = servicio.getUsuarios(); // llamamos al servicio
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}") // consultar un Usuario por su id
	public ResponseEntity<Usuario> getUsuarioId(@PathVariable Integer id) {
		Usuario Usuario = servicio.getUsuario(id);
		if (Usuario == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok(Usuario);

	}

	@PostMapping // añadir una nueva Usuario
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) { // en el postman escribir en el body raw
																				// // los datos del Usuario como en //
																				// // el JSON
		servicio.insertaUsuario(usuario);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}") // cuidado que ahora va con id
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) { // actualizar

		if (servicio.actualizaUsuario(usuario, id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();

		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Usuario> patchUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) { // actualizar
		if (servicio.patchUsuario(usuario, id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable Integer id) { // actualizar
		if (servicio.deleteUsuario(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
