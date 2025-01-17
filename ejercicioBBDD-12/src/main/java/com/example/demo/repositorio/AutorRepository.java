package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Autor;
@Repository
public class AutorRepository implements AutorRepositorioInterface{
	
	@Override
	public List<Autor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor getId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Autor autor) {
		// TODO Auto-generated method stub
		
	}

}
