package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;
import com.example.demo.repositorio.CursoRepoInterface;

import jakarta.transaction.Transactional;

@Service
public class CursoService implements CursoServInt{
	@Autowired
	private CursoRepoInterface repo;
	

	
	@Override
	@Transactional
	public void insert(Curso curso) {

		repo.save(curso);
		
	}

	@Override
	public List<Curso> getAll() {
		return repo.getAll();
	}

	@Override
	public Curso getId(Integer id) {
		return repo.getId(id);
	}

	@Override
	public void patch(Curso curso) {
		//no lo pedía el enunciado
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Curso encontrado = repo.getId(id);
		if (encontrado == null) {
			System.out.println("No se encontró el curso");
		} else {
			repo.delete(encontrado);
		}
		
	}

	@Override
	//es mas eficiente hacer una Query en la BD
	public List<Curso> containsPalabra(String palabra) {
		List<Curso> lista = repo.getAll().stream().filter(t -> t.getNombre().toLowerCase().contains(palabra.toLowerCase())).toList();
		 return lista;
	}

	@Override
	@Transactional
	public void deleteEstudiantedelCurso(Integer idCurso, Estudiante estudiante) {
		Curso curso = repo.getId(idCurso);
		if (curso == null) {
			System.out.println("No se encontró el curso"); }
		else {
		curso.getEstudiantes().remove(estudiante);
		//se borran de ambas listas al ser bidireccional
		estudiante.getCursos().remove(curso);
		repo.actualizar(curso); }
		
	}

}
