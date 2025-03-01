package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Pasaporte;
import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;

public interface ServiceInter {

	void insertPersona(Persona persona);
	
	void insertProyecto(Proyecto proyecto);
	
	void insertPasaporte(Pasaporte pasaporte);

	List<Persona> getAllPersonasWithProyectos();

	Persona getId(Integer id);

	void asignarPasaporte(Persona persona, Pasaporte pasaporte);

	void asignarProyecto(Persona persona, Proyecto proyecto);

	void removeProyectoFromPersona(Persona persona, Proyecto proyecto);
}
