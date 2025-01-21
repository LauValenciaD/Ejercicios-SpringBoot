package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;
import com.example.demo.repositorio.CursoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class CursoService implements CursoServInt{
	@Autowired
	private CursoRepositorio repo;
	
	@Override
	@Transactional
	public void insert(Curso curso) {
		repo.insert(curso);
		
	}

	@Override
	public List<Curso> getAll() {
		return repo.getAll();
	}

	@Override
	public Curso getEmpleado(Integer id) {
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
	public List<Curso> containsPalabra(String palabra) {
		List<Curso> lista = repo.getAll().stream().filter(t -> t.getNombre().contains(palabra)).toList();
		 return lista;
	}

	@Override
	@Transactional
	public void deleteEstudiantedelCurso(Integer idCurso, Estudiante estudiante) {
		Curso curso = repo.getId(idCurso);
		curso.getEstudiantes().remove(estudiante);
		repo.actualizar(curso);
		
	}

}
