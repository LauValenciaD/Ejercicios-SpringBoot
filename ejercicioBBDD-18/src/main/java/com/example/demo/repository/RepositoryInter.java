package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Pasaporte;
import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;

public interface RepositoryInter {
	//consultar
	List<Persona> getAll ();
	
	List<Persona> findAllWithProyectos ();
	
	//consultar por id
	Persona getId (Integer id);
	
	//crear
	void insertPersona (Persona persona);
	
	//actualizar info
	void actualizar (Persona persona);

	Proyecto getIdProyecto(Integer id);

	void insertPasaporte(Pasaporte pasaporte);

	void insertProyecto(Proyecto proyecto);
	
}
