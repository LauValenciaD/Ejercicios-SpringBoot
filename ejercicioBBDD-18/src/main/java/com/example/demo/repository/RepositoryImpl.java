package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositoryImpl implements RepositoryInter {

	 @PersistenceContext
	    private EntityManager entityManager;
	 //lista solo las personas
	@Override
	public List<Persona> getAll() {
		return entityManager.createQuery("FROM Persona p", Persona.class).getResultList();
	}
	  // Obtener todas las personas (únicas) con sus proyectos
	@Override
    public List<Persona> findAllWithProyectos() {
        return entityManager.createQuery(
            "SELECT DISTINCT p FROM Persona p LEFT JOIN FETCH p.proyectos", Persona.class
        ).getResultList();
    }

	@Override
	public Persona getId(Integer id) {
		return entityManager.find(Persona.class, id);
	}

	@Override
	public void insert(Persona persona) {
		entityManager.persist(persona);
		
	}

	@Override
	public void actualizar(Persona persona) {
		entityManager.merge(persona);
		
	}
	@Override
	public Proyecto getIdProyecto(Integer id) {
		return entityManager.find(Proyecto.class, id);
	}

}
