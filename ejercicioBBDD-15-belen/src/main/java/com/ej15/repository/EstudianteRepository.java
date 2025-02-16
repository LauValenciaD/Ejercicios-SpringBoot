package com.ej15.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ej15.model.Estudiante;

@Repository
public interface EstudianteRepository {

	void deleteById(Integer id);

	List<Estudiante> findByNombreContaining(String nombre);

	void delete(Estudiante estudiante);

	Estudiante findById(Integer id);

	List<Estudiante> findAll();

	Estudiante save(Estudiante estudiante);

}
