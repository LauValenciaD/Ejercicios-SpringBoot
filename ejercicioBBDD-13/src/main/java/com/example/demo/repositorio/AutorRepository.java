package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

	@Override
	public void insert(Autor autor) {
		entityManager.persist(autor);
		System.out.println("Hola desde insert");
		
	}

	@Override
	public void actualizar(Autor autor) {
		entityManager.merge(autor);
		
	}

	@Override
	public void delete(Autor autor) {
		entityManager.remove(autor);
		
	}

}
