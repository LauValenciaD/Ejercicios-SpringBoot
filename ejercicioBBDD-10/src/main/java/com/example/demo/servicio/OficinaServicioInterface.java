package com.example.demo.servicio;

import java.util.List;
import java.util.Map;

import com.example.demo.model.Oficina;

public interface OficinaServicioInterface {
	//crear oficina
		void insertOficina (Oficina oficina);
		
		//consultar oficinas
		List<Oficina> getOficinas ();
		
		//consultar por id
		Oficina getOficinaId (Integer id);
		
		//eliminar por id
		boolean deleteOficina (Integer id);
		
		//contar empleados
		Integer contarEmpleados (Integer id);
		
		//devolver un mapa id y num empleados
		Map<Integer, Integer> mapaOficina ();
		
		//list mas de n empleados
		List<Oficina> masXempleados(Integer numero);
		
		//actualizar telf
		void actualizarTelf (Integer id, String telefono);
}
