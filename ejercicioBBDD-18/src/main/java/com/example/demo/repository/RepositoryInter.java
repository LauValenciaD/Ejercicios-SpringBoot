package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;

public interface RepositoryInter {
	//consultar
	List<Persona> getAll ();
	
	List<Persona> findAllWithProyectos ();
	
	//consultar por id
	Persona getId (Integer id);
	
	//crear
	void insert (Persona persona);
	
	//actualizar info
	void actualizar (Persona persona);
	
	//eliminar
	void removeProyectoFromPersona (Persona persona, Proyecto proyecto);
}
