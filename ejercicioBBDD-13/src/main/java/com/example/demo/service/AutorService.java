package com.example.demo.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Autor;
import com.example.demo.models.Libro;
import com.example.demo.repositorio.AutorRepository;

import jakarta.transaction.Transactional;

@Service
public class AutorService implements ServiceInt {
	@Autowired
	private AutorRepository repo;

	@Override
	@Transactional
	public void save(Autor autor) {
		repo.save(autor);

	}

	@Override
	public List<Autor> getAll() {
		return repo.getAll();
	}

	@Override
	public Autor getId(Integer id) {
		
		return repo.getId(id);
	}

	@Override
	@Transactional
	public void addLibro(Libro libro, Integer idAutor) {
		Autor autor = repo.getId(idAutor);
		autor.addLibro(libro);
		repo.save(autor);

	}

	@Override
	@Transactional
	public void removeLibro(Integer libroId, Integer idAutor) {
		Autor autor = repo.getId(idAutor);
		Iterator<Libro> iterator= autor.getLibros().iterator();
		while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getId().equals(libroId)) {
                iterator.remove();
                break;
            }
        }
		repo.save(autor);

	}

	@Override
	public List<Libro> getAllLibros() {
		return repo.getAllLibros();
	}

	@Override
	public List<Autor> buscarPorNombre(String nombre) {
		return repo.buscarPorNombre(nombre);
	}

	@Override
	@Transactional
	public void actualizarAutorLibro(String nuevoNombre, String nombreLibro) {
		repo.actualizarTodosAutores(nuevoNombre, nombreLibro);

	}

	@Override
	public List<Libro> getLibrosFromAutor(Integer idAutor) {
		Autor autor = repo.getId(idAutor);
		return autor.getLibros();
	}

	@Override
	@Transactional
	public void updateLibro(Integer idLibro, String nombre) {
		Libro libro = repo.getIdLibro(idLibro);
		libro.setTitulo(nombre);
		repo.updateLibro(libro);
		
	}

	@Override
	@Transactional
	public void removeAutor(Integer id) {
		Autor autor = repo.getId(id);
		repo.delete(autor);
		
	}
}
