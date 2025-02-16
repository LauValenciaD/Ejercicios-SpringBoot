package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Autor;
import com.example.demo.models.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
@Repository
public class AutorRepository implements AutorRepositorioInterface{
	@PersistenceContext
	private EntityManager entityManager; // creamos el entityManager
	@Override
	public List<Autor> getAll() {
		return entityManager.createQuery("FROM Autor a", Autor.class).getResultList();
	}

	@Override
	public Autor getId(Integer id) {
		return entityManager.find(Autor.class, id);
	}

	// Crear o actualizar un curso
    @Override
    public void save(Autor autor) {
        if (autor.getId() == null) {
            entityManager.persist(autor); // Si el ID es nulo, es un nuevo curso, lo insertamos
        } else {
            entityManager.merge(autor); // Si ya existe, lo actualizamos
        }
    }


	@Override
	public void delete(Autor autor) {
		entityManager.remove(autor);
		
	}

	public List<Libro> getAllLibros() {
		return entityManager.createQuery("FROM Libro l", Libro.class).getResultList();
	}

	public List<Autor> buscarPorNombre(String nombre) {
		String consulta = "SELECT a FROM Autor a WHERE a.nombre LIKE :nombre";
		TypedQuery<Autor> query = entityManager.createQuery(consulta, Autor.class);
		query.setParameter("nombre", "%" + nombre + "%");
		return query.getResultList();
	}

	public Libro getIdLibro(Integer idLibro) {
		 if (idLibro == null) {
		        throw new IllegalArgumentException("El ID del libro no puede ser nulo");
		    }
		return entityManager.find(Libro.class, idLibro);
	}

	public void actualizarTodosAutores(String nuevoNombre, String nombreLibro) {
		String consulta = "SELECT a FROM Autor a JOIN a.libros l WHERE l.titulo = :nombreLibro";
		TypedQuery<Autor> query = entityManager.createQuery(consulta, Autor.class);
		query.setParameter("nombreLibro", "%" + nombreLibro + "%");
		List<Autor> listaAutores = query.getResultList();
		for (Autor autor : listaAutores) {
			autor.setNombre(nuevoNombre);
			entityManager.merge(autor);
		}
	}

	public void updateLibro(Libro libro) {
		entityManager.merge(libro);
		
	}

}
