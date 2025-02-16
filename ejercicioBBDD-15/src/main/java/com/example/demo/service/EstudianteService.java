package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;
import com.example.demo.repositorio.EstudianteRepoInter;

import jakarta.transaction.Transactional;

@Service
public class EstudianteService implements EstudianteServInter{
	@Autowired
	private EstudianteRepoInter repo;
	@Override
	public List<Estudiante> getAll() {
		return repo.getAll();
	}

	@Override
	public Estudiante getId(Integer id) {
		return repo.getId(id);
	}

	@Override
	@Transactional
	public void patchEmail(Integer id, String email) {
		Estudiante encontrado = repo.getId(id);
		encontrado.setEmail(email);
		
	}

	@Override
	public List<Estudiante> containsPalabra(String palabra) {
		List<Estudiante> lista = repo.getAll().stream().filter(t -> t.getNombre().toLowerCase().contains(palabra.toLowerCase())).toList();
		 return lista;
	}

}
