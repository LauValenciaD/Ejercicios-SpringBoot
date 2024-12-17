package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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

import com.example.demo.clases.Libro;






@RestController
@RequestMapping("/libros")
public class Controladores {
	private ArrayList<Libro> listaLibros = new ArrayList<>();
	private String[] genero1 = {"ficcion", "fantasia"};
	private String[] genero2 = {"comedia", "romance","novela"};
	
	public Controladores() {
		Libro libro1 = new Libro("1", "Quijote", "Autor1", "Anaya", "1234", 1650, genero1 );
		Libro libro2 = new Libro("2", "Libro2", "Autor1", "Santillana", "4561", 1953, genero1 );
		Libro libro3 = new Libro("3", "Libro3", "Autor2", "Anaya", "1234", 207, genero2 );
		Libro libro4 = new Libro("4", "Libro4", "Autor3", "Anaya", "1234", 1650, genero2 );
		
		listaLibros.add(libro1);
		listaLibros.add(libro2);
		listaLibros.add(libro3);
		listaLibros.add(libro4);
	}
	@GetMapping// Mostrar todos los libros
	public ResponseEntity<ArrayList> verLibros() {
		return ResponseEntity.ok(listaLibros); // la manera de Belen
	}
	@GetMapping("/{titulo}") // consultar un libro por su titulo
	public ResponseEntity<Libro> getTitulo(@PathVariable String titulo) {
		for (Libro libro : listaLibros) { // hacer un for each para ver todos los datos del cliente
			if (libro.getTitulo().equalsIgnoreCase(titulo)) // si coincide devuelve el cliente
			{
				return ResponseEntity.ok(libro);
			}
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping // añadir un nuevo libro
	public ResponseEntity<Libro> postLibro(@RequestBody Libro libro) { // en el postman escribir en el body raw los
																			// datos del cliente como en el JSON
		listaLibros.add(libro);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/{id}") //modificacion total
	public ResponseEntity<Libro> putAlumno(@RequestBody Libro book, @PathVariable String id) // busca a un cliente
																									// por id y lo
																									// actualiza
	{
		for (Libro libro : listaLibros) { // hacer un for each para ver todos los datos del cliente
			if (libro.getId().equalsIgnoreCase(id)) // si coincide devuelve el cliente
			{
				libro.setTitulo(book.getTitulo());
				libro.setAutor(book.getAutor());
				libro.setEditorial(book.getEditorial());
				libro.setIsbn(book.getIsbn());
				libro.setAñoPublicacion(book.getAñoPublicacion()); 
				libro.setGenero(book.getGenero()); 
				
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	@PatchMapping
	public ResponseEntity<Libro> patchCliente(@RequestBody Libro book) { //modificacion total
		for (Libro libro : listaLibros) {
			if (libro.getId() == book.getId()) {

				if (book.getTitulo() != null) {
				
					libro.setTitulo(book.getTitulo());
				}
				if (book.getAutor() != null) {
				
					libro.setAutor(book.getAutor());
				}
				if (book.getEditorial() != null) {
				
					libro.setEditorial(book.getEditorial());
				}
				if (book.getIsbn() != null) {
					
					libro.setIsbn(book.getIsbn());
				}
				if (book.getAñoPublicacion() != null) {
					libro.setAñoPublicacion(book.getAñoPublicacion());
				}
				if (book.getGenero() != null) {
					libro.setGenero(book.getGenero()); 
				}


				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{id}") //borrar libro por su id
	public ResponseEntity<Libro> deleteAlumno(@PathVariable String id) {
		Iterator<Libro> iterator = listaLibros.iterator(); // para borrar NO usar for each porque puede dar error
		while (iterator.hasNext()) {
			Libro libro = iterator.next();
			if (libro.getId().equalsIgnoreCase(id)) {
				iterator.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	@GetMapping ("/novelas") //obtener libros con el genero novela
	public ResponseEntity<ArrayList> obtenerNovelas(){
	ArrayList<Libro> listaNovelas = new ArrayList<>();
	for (Libro libro : listaLibros) {
		for (String s : libro.getGenero()) {
			if (s.equals("novela"))
			{ listaNovelas.add(libro);}			 
			}
		}
	return ResponseEntity.ok(listaNovelas);
	}
	@GetMapping ("/genero/{genero}") //obtener libros con el genero novela
	public ResponseEntity<ArrayList> obtenerPorGenero(@PathVariable String genero){
	ArrayList<Libro> listaGeneros = new ArrayList<>();
	for (Libro libro : listaLibros) {
		for (String s : libro.getGenero()) {
			if (s.equalsIgnoreCase(genero))
			{ listaGeneros.add(libro);}			 
			}
		}
	if(listaGeneros.isEmpty())
		return ResponseEntity.notFound().build();
	else {
	return ResponseEntity.ok(listaGeneros);}
	}
	@GetMapping("/autores/{numLibros}")
	public ResponseEntity<HashMap>	ObtenerAutoresConMasDeXLibros (@PathVariable Integer numLibros)
	{
		HashMap<String, Integer> autoresLibro = new HashMap<String, Integer>(); 
		for (Libro libro : listaLibros) {
			if (autoresLibro.containsKey(libro.getAutor()))
				autoresLibro.
		}
	}
}
