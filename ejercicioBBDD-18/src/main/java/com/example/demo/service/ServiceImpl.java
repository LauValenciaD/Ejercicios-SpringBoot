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
		persona.getProyectos().add(proyecto);
		personaRepository.actualizar(persona);
	}

	public void removeProyectoFromPersona(Persona persona, Proyecto proyecto) {
		personaRepository.removeProyectoFromPersona(persona, proyecto);
	}
}
