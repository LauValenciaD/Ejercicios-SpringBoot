package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Autor;
import com.example.demo.repositorio.AutorRepository;

import jakarta.transaction.Transactional;

@Service
public class AutorService {
 @Autowired
 private AutorRepository repo; 
 
 
 @Transactional
	public void insertAutor(Autor autor) {
		repo.insert(autor);

	}
 
	public List<Autor> getAutores() {
		return repo.getAll();
	}
	@Transactional
	public void patch(Autor autor) {
		repo.actualizar(autor);
	}
}
