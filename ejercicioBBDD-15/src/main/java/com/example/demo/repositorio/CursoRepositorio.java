package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class CursoRepositorio implements CursoRepoInterface {
	@PersistenceContext
	private EntityManager entityManager; // creamos el entityManager

	@Override
	public List<Curso> getAll() {
		return entityManager.createQuery("FROM Curso c", Curso.class).getResultList();
	}

	@Override
	public Curso getId(Integer id) {
		return entityManager.find(Curso.class, id);
	}

    // Crear o actualizar un curso
    @Override
    public void save(Curso curso) {
        if (curso.getId() == null) {
            entityManager.persist(curso); // Si el ID es nulo, es un nuevo curso, lo insertamos
        } else {
            entityManager.merge(curso); // Si ya existe, lo actualizamos
        }
    }
	@Override
	public void actualizar(Curso curso) {
		entityManager.merge(curso);

	}

	@Override
	public void delete(Curso curso) {
		entityManager.remove(curso);

	}

}
