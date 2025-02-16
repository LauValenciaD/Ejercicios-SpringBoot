package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.model.Curso;



public interface CursoRepoInterface {
	//consultar oficinas
	List<Curso> getAll ();
	
	//consultar por id
	Curso getId (Integer id);
	
	//crear oficina
	void save (Curso curso);
	
	//actualizar info
	void actualizar (Curso curso);
	
	//eliminar autor
	void delete (Curso curso);
	
}
