package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Estudiante;

public interface EstudianteServInter {
	//consultar todos
		List<Estudiante> getAll ();
		
		//consultar por id
		Estudiante getId (Integer id);
		
		//actualizar info
		void patchEmail (Integer id, String email);
		
		//curso que contenga una palabra específica
		List<Estudiante> containsPalabra (String palabra);
}
