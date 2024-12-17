package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Vehiculo;
import com.example.demo.repositorioDAO.RepositorioVehiculo;

import jakarta.transaction.Transactional;

public class Servicio {

		@Autowired
		private RepositorioVehiculo repositorio;

		public List<Vehiculo> getVehiculos() {
			return repositorio.getVehiculos();
		}

		@Transactional
		public Vehiculo insertaVehiculo(Vehiculo ve) {
			return repositorio.insertaVehiculo(ve);
		}

		public Vehiculo getVehiculo(Integer id) {
			return repositorio.getVehiculo(id);
		}
		@Transactional
		public void actualizaVehiculo(Vehiculo vehiculo) {
			 repositorio.actualizaVehiculo(vehiculo);
		}
		
		@Transactional
		public void deleteVehiculo(Vehiculo vehiculo) {
			repositorio.deleteVehiculo(vehiculo);
		}

//	public List<Cliente> getClientesNombre(String nombre) {
//		return repositorio.getClientesNombre(nombre);
//	}
	
}
