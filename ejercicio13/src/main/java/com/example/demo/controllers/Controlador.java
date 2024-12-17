package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import com.example.demo.clases.Tarea;
import com.example.demo.clases.Tarea.Estado;

@RestController
@RequestMapping("/tareas")
public class Controlador {
	private ArrayList<Tarea> listaTareas = new ArrayList<>();

	public Controlador() {
		Tarea tarea1 = new Tarea(1, "Rellenar formulario", "escribir el formulario", LocalDate.of(2024, 10, 25),
				Tarea.Estado.PENDIENTE);
		Tarea tarea2 = new Tarea(2, "Redactar informe", "Escribir el informe final del proyecto",
				LocalDate.of(2024, 11, 10), Tarea.Estado.EN_PROCESO);
		Tarea tarea3 = new Tarea(3, "Terminar proyecto de Java",
				"Completar la implementación y las pruebas del proyecto.", LocalDate.of(2024, 10, 30),
				Tarea.Estado.PENDIENTE);
		Tarea tarea4 = new Tarea(4, "Planificar reunión", "Coordinar la próxima reunión con el equipo.",
				LocalDate.of(2024, 10, 25), Tarea.Estado.COMPLETA);
		listaTareas.add(tarea1);
		listaTareas.add(tarea2);
		listaTareas.add(tarea3);
		listaTareas.add(tarea4);
	}

	@GetMapping // Mostrar todos las tareas
	public ResponseEntity<ArrayList> verTareas() {
		return ResponseEntity.ok(listaTareas);
	}

	@GetMapping("/{id}") // consultar una pelicula por su id
	public ResponseEntity<Tarea> getTitulo(@PathVariable("id") int id) {
		for (Tarea tarea : listaTareas) { // hacer un for each para ver todos los datos
			if (tarea.getId() == id) {
				return ResponseEntity.ok(tarea);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping // añadir una nueva tarea
	public ResponseEntity<Tarea> postTarea(@RequestBody Tarea tarea) { // en el postman escribir en el body raw
		// datos como en el JSON
		listaTareas.add(tarea);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}") // modificacion total
	public ResponseEntity<Tarea> putTarea(@RequestBody Tarea task, @PathVariable("id") int id) // busca a un cliente //
																								// actualiza
	{
		for (Tarea tarea : listaTareas) { // hacer un for each para ver todos los datos del cliente
			if (tarea.getId() == id) // si coincide devuelve el cliente
			{
				tarea.setTitulo(task.getTitulo());
				tarea.setDescripcion(task.getDescripcion());
				tarea.setFechaFin(task.getFechaFin());
				tarea.setEstado(task.getEstado());
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PatchMapping("/{id}") // modificacion parcial por id
	public ResponseEntity<Tarea> patchTarea(@RequestBody Tarea task, @PathVariable("id") int id) { // modificacion total
		for (Tarea tarea : listaTareas) {
			if (tarea.getId() == id) {

				if (task.getTitulo() != null) {

					tarea.setTitulo(task.getTitulo());
				}
				if (task.getDescripcion() != null) {

					tarea.setDescripcion(task.getDescripcion());
				}
				if (task.getFechaFin() != null) {

					tarea.setFechaFin(task.getFechaFin());
				}
				if (task.getEstado() != null) {

					tarea.setEstado(task.getEstado());
				}

				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}") // borrar por su id
	public ResponseEntity<Tarea> deleteTarea(@PathVariable("id") int id) {
		Iterator<Tarea> iterator = listaTareas.iterator(); // para borrar NO usar for each porque puede dar error
		while (iterator.hasNext()) {
			Tarea tarea = iterator.next();
			if (tarea.getId() == id) {
				iterator.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/estado/{estado}")
	public ResponseEntity<List> obtenerPorEstado(@PathVariable("estado") String estado) {
		// Convertir el valor del PathVariable a mayúsculas
		Estado estadoEnum = Estado.valueOf(estado.toUpperCase());
		List<Tarea> listaEstado = new ArrayList<>();
		for (Tarea tarea : listaTareas) {
			if (tarea.getEstado() == estadoEnum) {
				listaEstado.add(tarea);
			}
		}
		if (listaEstado.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(listaEstado);
		}
	}

	@GetMapping("/proximas/{dias}")
	public ResponseEntity<List> obtenerTareasProximas(@PathVariable("dias") int dias) {
		LocalDate fechaHoy = LocalDate.now();
		LocalDate fechaLimite = fechaHoy.plusDays(dias);
		List<Tarea> listaProximas = new ArrayList<>();
		for (Tarea tarea : listaTareas) {
			if (tarea.getFechaFin().isBefore(fechaLimite) && tarea.getEstado() != Estado.COMPLETA) { //que este dentro de la fecha y no este completa
				listaProximas.add(tarea);
			}
		}
		if (listaProximas.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(listaProximas);
		}
	}
	/*  Obtener Tareas por Palabra Clave en Descripción: /buscar/{palabraClave}
 Marcar tareas como completadas: PATCH /marcar-completadas: Todas las tareas vencidas,
aquellas cuya fecha ya ha pasado, deben marcarse como COMPLETA */
}
