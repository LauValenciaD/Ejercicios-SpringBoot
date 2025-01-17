package com.example.demo.repositorio;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Oficina;

@Repository
public interface OficinaRepositoryInterface {
	//crear oficina
	void insertOficina (Oficina oficina);
	
	//consultar oficinas
	List<Oficina> getOficinas ();
	
	//consultar por id
	Oficina getOficinaId (Integer id);
	
	//eliminar por id
	void deleteOficina (Oficina oficina);
	
	//actualizar telf
	void actualizarTelf (Integer id, String telefono);
}
