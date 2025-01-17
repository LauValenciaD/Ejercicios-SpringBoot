package com.example.demo.servicio;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Empleado;
import com.example.demo.model.Oficina;
import com.example.demo.repositorio.OficinaRepository;

import jakarta.transaction.Transactional;

@Service
public class OficinaServicio implements OficinaServicioInterface {

	@Autowired
	private OficinaRepository oficinaRepository;

	@Override
	@Transactional
	public void insertOficina(Oficina oficina) {
		oficinaRepository.insertOficina(oficina);

	}

	@Override
	public List<Oficina> getOficinas() {
		// TODO Auto-generated method stub
		return oficinaRepository.getOficinas();
	}

	@Override
	public Oficina getOficinaId(Integer id) {
		// TODO Auto-generated method stub
		return oficinaRepository.getOficinaId(id);
	}

	@Override
	public boolean deleteOficina(Integer id) {
		Oficina encontrado = oficinaRepository.getOficinaId(id);
		if (encontrado == null) {
			return false;
		} else {
			oficinaRepository.deleteOficina(encontrado);
			return true;
		}
	}

	// Contar empleados de una oficina
	public Integer contarEmpleados(Integer id) {
		return oficinaRepository.contarEmpleados(id);
	}

	// Devolver un mapa con id de oficina y número de empleados
	public Map<Integer, Integer> mapaOficina() {
		return oficinaRepository.mapaOficina();
	}

	// Devolver oficinas con más de N empleados
	public List<Oficina> masXempleados(Integer numero) {
		return oficinaRepository.masXempleados(numero);
	}

	// Actualizar el teléfono de una oficina dado el id de un empleado
	public void actualizarTelf(Integer empleadoId, String telefono) {
		oficinaRepository.actualizarTelf(empleadoId, telefono);
	}

}
