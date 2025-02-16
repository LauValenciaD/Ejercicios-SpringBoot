package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Autor;
import com.example.demo.models.Libro;
@Service
public interface ServiceInt {
	List<Autor> getAll();
	
	Autor getId(Integer id);
	
	void save(Autor autor);
	
	void removeAutor(Integer id);
	
	void addLibro(Libro libro, Integer idAutor);
	
	void removeLibro(Integer libroId, Integer idAutor);
	
	List<Libro> getLibrosFromAutor(Integer idAutor);
	
	void updateLibro(Integer idLibro, String nombre);
	
	List<Libro> getAllLibros();
	
	List<Autor> buscarPorNombre(String nombre);
	
	void actualizarAutorLibro(String nuevoNombre, String nombreLibro);
}
