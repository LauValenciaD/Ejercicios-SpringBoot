package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

public interface CursoServInt {
	//crear
	void insert (Curso curso);
	
	//consultar todos
	List<Curso> getAll ();
	
	//consultar por id
	Curso getEmpleado (Integer id);
	
	//actualizar info
	void patch (Curso curso);
	
	//eliminar
	void delete (Integer id);
	
	//curso que contenga una palabra específica
	List<Curso> containsPalabra (String palabra);
	
	//eliminar un estudiante de un curso
	void deleteEstudiantedelCurso (Integer idCurso, Estudiante estudiante);
	
	
}
