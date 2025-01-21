package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.model.Estudiante;



public interface EstudianteRepoInter {
	//consultar oficinas
	List<Estudiante> getAll ();
	
	//consultar por id
	Estudiante getId (Integer id);
	
	//actualizar info
	void actualizar (Estudiante estudiante);
}
