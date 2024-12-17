package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.example.demo.clases.Pelicula;
import com.example.demo.clases.Actor;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

@RestController
@RequestMapping("/peliculas")
public class Controladores {
	private ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

	public Controladores() {
		Actor actor1 = new Actor(1, "Will Smith", "US");
		Actor actor2 = new Actor(2, "Penelope Cruz", "española");
		Actor actor3 = new Actor(3, "Jhonny Depp", "US");
		Actor actor4 = new Actor(4, "Chris Hemswoth", "Australia");
		Actor actor5 = new Actor(5, "Ryan Reynolds", "US");

		listaPeliculas.add(
				new Pelicula(1, "Deadpool 1", "Director A", LocalDate.of(2016, 7, 15), 140, List.of(actor5, actor1)));
		listaPeliculas.add(new Pelicula(2, "Deadpool 3", "Director A", LocalDate.of(2024, 7, 15), 260,
				List.of(actor5, actor1, actor2)));
		listaPeliculas.add(new Pelicula(3, "Piratas del Caribe 4", "Director B", LocalDate.of(2015, 7, 15), 240,
				List.of(actor2, actor3)));
		listaPeliculas
				.add(new Pelicula(4, "Thor 2", "Director C", LocalDate.of(2020, 7, 15), 240, List.of(actor4, actor5)));
	}

	@GetMapping // Mostrar todos las peliculas
	public ResponseEntity<ArrayList> verLibros() {
		return ResponseEntity.ok(listaPeliculas);
	}

	@GetMapping("/{titulo}") // consultar una pelicula por su titulo
	public ResponseEntity<Pelicula> getTitulo(@PathVariable String titulo) {
		for (Pelicula pelicula : listaPeliculas) { // hacer un for each para ver todos los datos del cliente
			if (pelicula.getTitulo().equalsIgnoreCase(titulo)) // si coincide devuelve el cliente
			{
				return ResponseEntity.ok(pelicula);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping // añadir una nueva pelicula
	public ResponseEntity<Pelicula> postLibro(@RequestBody Pelicula pelicula) { // en el postman escribir en el body raw
																				// los
		// datos del cliente como en el JSON
		listaPeliculas.add(pelicula);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}") // modificacion total
	public ResponseEntity<Pelicula> putAlumno(@RequestBody Pelicula film, @PathVariable int id) // busca a un cliente //
																								// actualiza
	{
		for (Pelicula pelicula : listaPeliculas) { // hacer un for each para ver todos los datos del cliente
			if (pelicula.getId() == id) // si coincide devuelve el cliente
			{
				pelicula.setTitulo(film.getTitulo());
				pelicula.setDirector(film.getDirector());
				pelicula.setFechaLanzamiento(film.getFechaLanzamiento());
				pelicula.setDuracion(film.getDuracion());
				pelicula.setActores(film.getActores());

				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PatchMapping
	public ResponseEntity<Pelicula> patchCliente(@RequestBody Pelicula film) { // modificacion total
		for (Pelicula pelicula : listaPeliculas) {
			if (pelicula.getId() == film.getId()) {

				if (film.getTitulo() != null) {

					pelicula.setTitulo(film.getTitulo());
				}
				if (film.getDirector() != null) {

					pelicula.setDirector(film.getDirector());
				}
				if (film.getFechaLanzamiento() != null) {

					pelicula.setFechaLanzamiento(film.getFechaLanzamiento());
				}
				if (film.getDuracion() != 0) {

					pelicula.setDuracion(film.getDuracion());
				}
				if (film.getActores() != null) {
					pelicula.setActores(film.getActores());
				}

				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}") // borrar pelicula por su id
	public ResponseEntity<Pelicula> deleteAlumno(@PathVariable int id) {
		Iterator<Pelicula> iterator = listaPeliculas.iterator(); // para borrar NO usar for each porque puede dar error
		while (iterator.hasNext()) {
			Pelicula pelicula = iterator.next();
			if (pelicula.getId() == id) {
				iterator.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/director/{director}") // obtener peliculas con un director especifico
	public ResponseEntity<ArrayList> obtenerPorDirector(@PathVariable("director") String director) {
		ArrayList<Pelicula> listaDirectores = new ArrayList<>();
		for (Pelicula pelicula : listaPeliculas) {
			if (pelicula.getDirector().equalsIgnoreCase(director)) {
				listaDirectores.add(pelicula);
			}
		}
		if (listaDirectores.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			return ResponseEntity.ok(listaDirectores);
		}
	}

	@GetMapping("/directores/{numPeliculas}") // obtener directores con mas x pelis
	public ResponseEntity<Map> ObtenerDirectoresConMasDeXPeliculas(@PathVariable("numPeliculas") int numPeliculas) {
		Map<String, Integer> conteoPorDirector = new HashMap<>();
		for (Pelicula pelicula : listaPeliculas) {
			String director = pelicula.getDirector();
			conteoPorDirector.put(director, conteoPorDirector.getOrDefault(director, 0) + 1);
		}
		// Filtrar directores con mas x pelis
		Map<String, Integer> directorFiltro = new HashMap<>();

		for (Entry<String, Integer> entry : conteoPorDirector.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			if (val > numPeliculas) {
				directorFiltro.put(key, val);
			}
		}
		return ResponseEntity.ok(directorFiltro);
	}

	@GetMapping("/duracion") // obtener pelicula con la maxima duracion
	public ResponseEntity<Pelicula> obtenerPorDuracion() {
		int duracionMax = 0;
		int id = 0;
		for (int i = 0; i < listaPeliculas.size(); i++) {
			if (listaPeliculas.get(i).getDuracion() > duracionMax) {
				duracionMax = listaPeliculas.get(i).getDuracion();
				id = i;
			}
		}
		return ResponseEntity.ok(listaPeliculas.get(id));
	}

	@GetMapping("/actores")
	public ResponseEntity<HashSet> listaActores() {
		HashSet<Actor> listaActores = new HashSet<>();
		for (Pelicula pelicula : listaPeliculas) {
			for (int i = 0; i < pelicula.getActores().size(); i++) {
				listaActores.add(pelicula.getActores().get(i));
			}
		}
		return ResponseEntity.ok(listaActores);
	}

	@GetMapping("/5years") // obtener en los ultimos 5 años
	public ResponseEntity<List> obtenerPor5años() {
		List<Pelicula> miLista = new ArrayList<>();
		LocalDate fechaActual = LocalDate.now();
		LocalDate fecha5 = fechaActual.minusYears(5);
		for (Pelicula pelicula : listaPeliculas) {
			if (pelicula.getFechaLanzamiento().isAfter(fecha5)) {
				miLista.add(pelicula);
			}
		}
		if (miLista.isEmpty()) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok(miLista);
		}

	}

	@GetMapping("/actor/{name}") // obtener pelis con un actor especifico
	public ResponseEntity<List> obtenerPeliculasPorActor(@PathVariable("name") String name) {
		List<Pelicula> miLista = new ArrayList<>();
		for (Pelicula pelicula : listaPeliculas) {
			for (Actor actor : pelicula.getActores()) {
				if (actor.getNombre().equalsIgnoreCase(name)) {
					miLista.add(pelicula);
				}
			}
		}
		if (miLista.isEmpty()) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok(miLista);
		}
	}
	@GetMapping("/actor/nacionalidad/{nacionalidad}") // obtener actores con una nacionalidad especifica
	public ResponseEntity<HashSet> ObtenerActoresPorNacionalidad(@PathVariable ("nacionalidad") String nacionalidad) {
		HashSet<Actor> listaActores = new HashSet<>();
		for (Pelicula pelicula : listaPeliculas) {
			for (Actor actor : pelicula.getActores()) {
				if (actor.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
					listaActores.add(actor);
				}
			}
		}
		if (listaActores.isEmpty()) {
			return ResponseEntity.notFound().build();

		} else {
			return ResponseEntity.ok(listaActores);
		}
	}
}
