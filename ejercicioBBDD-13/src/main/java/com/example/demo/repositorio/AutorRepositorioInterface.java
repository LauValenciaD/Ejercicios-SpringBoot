package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Autor;



@Repository
public interface AutorRepositorioInterface {
	//consultar oficinas
		List<Autor> getAll ();
		
		//consultar por id
		Autor getId (Integer id);
		
		//crear oficina
		void save (Autor autor);

		//eliminar autor
		void delete (Autor autor);
		
}
