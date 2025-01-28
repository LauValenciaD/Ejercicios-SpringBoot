package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pasaporte;
import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;
import com.example.demo.repository.RepositoryInter;

import jakarta.transaction.Transactional;

@Service
public class ServiceImpl implements ServiceInter {
	@Autowired
	private RepositoryInter personaRepository;

	@Transactional
	public void insert(Persona persona) {
		personaRepository.insert(persona);
	}

	public List<Persona> getAllPersonasWithProyectos() {
		return personaRepository.findAllWithProyectos();
	}

	public Persona getId(Integer id) {
		return personaRepository.getId(id);
	}
	
	public Proyecto getIdProyecto(Integer id) {
		return personaRepository.getIdProyecto(id);
	}


	@Transactional
	public void asignarPasaporte(Persona persona, Pasaporte pasaporte) {
		Persona encontrado = personaRepository.getId(persona.getId());
		if (encontrado == null) {
			personaRepository.insert(persona); // insertar persona si aún no está en la BD
		}
		if (encontrado != null) {
			pasaporte.setPersona(encontrado);
			encontrado.setPasaporte(pasaporte);
			personaRepository.actualizar(encontrado); 
		}
	}

	@Transactional
	public void asignarProyecto(Persona persona, Proyecto proyecto) {
		Persona encontrada = personaRepository.getId(persona.getId());
		Proyecto proyectoEncontrado = personaRepository.getIdProyecto(proyecto.getId()); //comprobar que esta insertado en la BD
		encontrada.agregarProyecto(proyectoEncontrado); //llamamos el metodo de la clase persona
		personaRepository.actualizar(encontrada);
	}
	@Transactional
	public void removeProyectoFromPersona(Persona persona, Proyecto proyecto) {
		Persona encontrada = personaRepository.getId(persona.getId());
		Proyecto proyectoEncontrado = personaRepository.getIdProyecto(proyecto.getId());
		encontrada.borrarProyecto(proyectoEncontrado); //llamamos el metodo de la clase persona
		personaRepository.actualizar(encontrada);
	}
}
