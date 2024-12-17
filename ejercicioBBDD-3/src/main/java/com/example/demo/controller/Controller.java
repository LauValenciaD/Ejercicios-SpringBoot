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

import com.example.demo.model.Vehiculo;
import com.example.demo.service.Servicio;



public class Controller {
	@Autowired // conectar con el autowired
	private Servicio servicio; // crear una variable de la clase VehiculoServicio

	@GetMapping // Mostrar todos los Vehiculos
	public ResponseEntity<List> getVehiculos() {
		List<Vehiculo> lista = servicio.getVehiculos(); // llamamos al servicio
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}") // consultar un Vehiculo por su titulo
	public ResponseEntity<Vehiculo> getTitulo(@PathVariable Integer id) {
		Vehiculo vehiculo = servicio.getVehiculo(id);
		if (vehiculo == null) {
			return ResponseEntity.notFound().build();
		} else
			return ResponseEntity.ok(vehiculo);

	}

	@PostMapping // añadir una nueva Vehiculo
	public ResponseEntity<Vehiculo> postVehiculo(@RequestBody Vehiculo vehiculo) { // en el postman escribir en el body raw
																				// // los datos del Vehiculo como en //
																				// el JSON
		servicio.insertaVehiculo(vehiculo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}") // cuidado que ahora va con id
	public ResponseEntity<Vehiculo> putVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable Integer id) { // actualizar
																										// total
		vehiculo.setId(id);
		Vehiculo encontrado = servicio.getVehiculo(id);

		if (encontrado == null) {
			return ResponseEntity.notFound().build();
		} else {
			servicio.actualizaVehiculo(vehiculo);
			return ResponseEntity.noContent().build();
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Vehiculo> patchVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable Integer id) { // actualizar
		Vehiculo encontrado = servicio.getVehiculo(id);

		if (encontrado == null) {
			return ResponseEntity.notFound().build();
		} else {
			if (vehiculo.getMarca() != null) {
				encontrado.setMarca(vehiculo.getMarca());
			}
			if (vehiculo.getModelo() != null) {
				encontrado.setModelo(vehiculo.getModelo());
			} // total
			
			if (vehiculo.getAnyo() != null) {
				encontrado.setAnyo(vehiculo.getAnyo());
			}
			
			if (vehiculo.getMatricula() != null) {
				encontrado.setMatricula(vehiculo.getMatricula());
			}
			
			if (vehiculo.getEstado() != null) {
				encontrado.setEstado(vehiculo.getEstado());
			}
			
			if (vehiculo.getKilometraje() != null) {
				encontrado.setKilometraje(vehiculo.getKilometraje());
			}
			
			servicio.actualizaVehiculo(vehiculo);
			return ResponseEntity.noContent().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Vehiculo> deleteVehiculo(@RequestBody Integer id) { // actualizar
		Vehiculo encontrado = servicio.getVehiculo(id);
		if (encontrado == null) {
			return ResponseEntity.notFound().build();
		} else { // total
			servicio.deleteVehiculo(encontrado);
			return ResponseEntity.noContent().build();
		}
	}

	/*
	 * getVehiculosNombre: dado un nombre, obtiene la lista de todos los Vehiculos
	 * cuyo nombre contenga el nombre a buscar.
	 */
//	@GetMapping("/{nombre}")
//	public ResponseEntity<List> getVehiculosNombre(@RequestBody String nombre) {
//		List<Vehiculo> lista = servicio.getVehiculosNombre(nombre); // llamamos al servicio
//		return ResponseEntity.ok(lista);
//	}
}
