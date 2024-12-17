package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.example.demo.clases.Album;
import com.example.demo.clases.Artista;
import com.example.demo.clases.Cancion;

@RestController
@RequestMapping("/album")
public class ControladorAlbum {
	private List<Album> listaAlbums = new ArrayList<>();

	public ControladorAlbum() {
		// Creación de artistas
		Artista artista1 = new Artista(1, "Led Zeppelin", "Reino Unido");
		Artista artista2 = new Artista(2, "Pink Floyd", "Reino Unido");
		Artista artista3 = new Artista(3, "Nirvana", "Estados Unidos");
		Artista artista4 = new Artista(4, "AC DC", "Australia");

		// Creación de canciones y álbumes

		// Album 1
		List<Cancion> cancionesAlbum1 = Arrays.asList(new Cancion(1, "Whole Lotta Love", Arrays.asList(artista1)),
				new Cancion(2, "Ramble On", Arrays.asList(artista1)));
		Album album1 = new Album(1, "Led Zeppelin II", artista1, 1969, cancionesAlbum1);

		// Album 2
		List<Cancion> cancionesAlbum2 = Arrays.asList(
				new Cancion(3, "Another Brick in the Wall", Arrays.asList(artista2)),
				new Cancion(4, "Comfortably Numb", Arrays.asList(artista2)));
		Album album2 = new Album(2, "The Wall", artista2, 1979, cancionesAlbum2);

		// Album 3
		List<Cancion> cancionesAlbum3 = Arrays.asList(
				new Cancion(5, "Smells Like Teen Spirit", Arrays.asList(artista3)),
				new Cancion(6, "Come As You Are", Arrays.asList(artista3)));
		Album album3 = new Album(3, "Nevermind", artista3, 1991, cancionesAlbum3);

		// Album 4
		List<Cancion> cancionesAlbum4 = Arrays.asList(new Cancion(7, "Back In Black", Arrays.asList(artista4)),
				new Cancion(8, "Hells Bells", Arrays.asList(artista4)));
		Album album4 = new Album(4, "Back In Black", artista4, 1980, cancionesAlbum4);

		listaAlbums.add(album1);
		listaAlbums.add(album2);
		listaAlbums.add(album3);
		listaAlbums.add(album4);
	}

	@GetMapping // Mostrar todos los albums
	public ResponseEntity<List> verAlbums() {
		return ResponseEntity.ok(listaAlbums);
	}

	@GetMapping("/{titulo}") // consultar un album por su titulo
	public ResponseEntity<Album> getTitulo(@PathVariable("titulo") String titulo) {
		for (Album album : listaAlbums) { // hacer un for each para ver todos los datos
			if (album.getTitulo().equalsIgnoreCase(titulo)) {
				return ResponseEntity.ok(album);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping // añadir un nuevo Album
	public ResponseEntity<Album> postAlbum(@RequestBody Album Album) { // en el postman escribir en el body raw
		// datos como en el JSON
		listaAlbums.add(Album);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}") // modificacion total
	public ResponseEntity<Album> putAlbum(@RequestBody Album alb, @PathVariable("id") int id) // busca a un cliente //
																								// actualiza
	{
		for (Album album : listaAlbums) { // hacer un for each para ver todos los datos del cliente
			if (album.getId() == id) // si coincide devuelve el cliente
			{
				album.setTitulo(alb.getTitulo());
				album.setArtistaPrincipal(alb.getArtistaPrincipal());
				album.setAnyo(alb.getAnyo());
				album.setCanciones(alb.getCanciones());
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PatchMapping("/{id}") // modificacion parcial por id
	public ResponseEntity<Album> patchAlbum(@RequestBody Album alb, @PathVariable("id") int id) { // modificacion total
		for (Album album : listaAlbums) {
			if (album.getId() == id) {

				if (alb.getTitulo() != null) {

					album.setTitulo(alb.getTitulo());
				}
				if (alb.getArtistaPrincipal() != null) {

					album.setArtistaPrincipal(alb.getArtistaPrincipal());
				}
				if (alb.getAnyo() != 0) {

					album.setAnyo(alb.getAnyo());
				}
				if (alb.getCanciones() != null) {

					album.setCanciones(alb.getCanciones());
				}

				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}") // borrar por su id
	public ResponseEntity<Album> deleteAlbum(@PathVariable("id") int id) {
		Iterator<Album> iterator = listaAlbums.iterator(); // para borrar NO usar for each porque puede dar error
		while (iterator.hasNext()) {
			Album album = iterator.next();
			if (album.getId() == id) {
				iterator.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	// obtener todas las canciones de un album especifico
	@GetMapping("/canciones/{id}")
	public ResponseEntity<List> getCanciones(@PathVariable("id") int id) {
		for (Album album : listaAlbums) { // hacer un for each para ver todos los datos
			if (album.getId() == id) {
				return ResponseEntity.ok(album.getCanciones());
			}
		}
		return ResponseEntity.notFound().build();
	}

	// Obtener todas las canciones de un artista especifico
	@GetMapping("/artista/{nombre}")
	public ResponseEntity<List> getCancionesArtista(@PathVariable("nombre") String nombre) {
		List<Cancion> playlist = new ArrayList<>();
		for (Album album : listaAlbums) {
			for (Cancion cancion : album.getCanciones()) {
				for (Artista artista : cancion.getArtistas()) {
					if (artista.getNombre().equalsIgnoreCase(nombre)) {
						playlist.add(cancion);
					}
				}
			}
		}
		if (playlist.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			return ResponseEntity.ok(playlist);
		}
	}
	
	//  Obtener todos los artistas de una canción específica.
	@GetMapping("/artista/cancion/{nombre}")
	public ResponseEntity<List> getArtistasDeCancion(@PathVariable String nombre) {
		List<Artista> playlist = new ArrayList<>();
		for (Album album : listaAlbums) {
			for (Cancion cancion : album.getCanciones()) {
				if (cancion.getTitulo().equalsIgnoreCase(nombre)) {
				for (Artista artista : cancion.getArtistas()) {
						playlist.add(artista);
					}
				}
			}
		}
		if (playlist.isEmpty())
			return ResponseEntity.notFound().build();
		else {
			return ResponseEntity.ok(playlist);
		}
	}
}
