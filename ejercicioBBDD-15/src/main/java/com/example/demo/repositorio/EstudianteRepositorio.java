package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class EstudianteRepositorio implements EstudianteRepoInter{
	@PersistenceContext
	private EntityManager entityManager; // creamos el entityManager
	
	@Override
	public List<Estudiante> getAll() {
		return entityManager.createQuery("FROM Estudiante e", Estudiante.class).getResultList();
	}

	@Override
	public Estudiante getId(Integer id) {
		return entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		entityManager.merge(estudiante);
		
	}

}
