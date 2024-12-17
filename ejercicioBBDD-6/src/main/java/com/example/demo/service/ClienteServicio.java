package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.models.Direccion;
import com.example.demo.repository.ClienteRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicio implements ServiceInterface {
	@Autowired
	private ClienteRepositorio repositorio;

	public List<Cliente> getClientes() {
		return repositorio.getClientes();
	}

	@Transactional
	public void insertaCliente(Cliente cl) {
		repositorio.insert(cl);
	}

	public Cliente getCliente(Integer id) {
		return repositorio.get(id);
	}

	@Transactional
	public boolean actualizaCliente(Cliente cliente, Integer id) {
		Cliente encontrado = repositorio.get(id);
		if (encontrado == null) {
			return false;
		} else {
//			cliente.setId(id); // Seteamos el ID recibido al cliente para no tener que ponerlo en el body
//			cliente.getDireccion().setId(encontrado.getDireccion().getId());
			repositorio.actualizarCliente(cliente);
			return true;
		}
	}

	@Transactional
	public boolean patchCliente(Cliente cliente, Integer id) {
		Cliente encontrado = repositorio.get(id);
		if (encontrado == null) {
			return false;
		} else {
			if (cliente.getNombre() != null) {
				encontrado.setNombre(cliente.getNombre());
			}
			if (cliente.getDireccion() != null) {
				encontrado.setDireccion(cliente.getDireccion());
			}
			repositorio.actualizarCliente(encontrado);
			return true;
		}
	}

	@Transactional
	public boolean deleteCliente(Integer id) {
		Cliente encontrado = repositorio.get(id);
		if (encontrado == null) {
			return false;
		} else {
			repositorio.delete(encontrado);
			return true;
		}
	}

	public List<Cliente> getClientesCiudad(String ciudad) {
		return repositorio.buscarPorCiudad(ciudad);
	}

	@Transactional // importante!
	public boolean actualizaDireccion(Direccion nuevaDireccion, Integer id) {
		// Buscar cliente por ID
		Cliente encontrado = repositorio.get(id);
		if (encontrado == null) {
			return false;
		} else {

			// Si la dirección ya existe en el cliente, actualiza los valores
			if (encontrado.getDireccion() != null) {
				encontrado.getDireccion().setCalle(nuevaDireccion.getCalle());
				encontrado.getDireccion().setCiudad(nuevaDireccion.getCiudad());
			} else {
				// Si no hay dirección, asigna la nueva dirección
				encontrado.setDireccion(nuevaDireccion);
			}

			// Guardar el cliente (propaga cambios en la dirección)
			repositorio.actualizarCliente(encontrado);
			return true;
		}
	}

	@Transactional // importante!
	public boolean cambiarSevilla() {
		List<Cliente> lista = repositorio.getClientes();
		List<Cliente> listaCambios = new ArrayList<>();
		for (Cliente cliente : lista) {
			if (cliente.getNombre().toLowerCase().startsWith("a")) {
				cliente.getDireccion().setCiudad("Sevilla");
				repositorio.actualizarCliente(cliente);
				listaCambios.add(cliente);
			}
		}
		if (listaCambios.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional // importante!
	public boolean cambiarCiudad(String ciudad, String letra) {
		List<Cliente> lista = repositorio.getClientes();
		List<Cliente> listaCambios = new ArrayList<>();
		for (Cliente cliente : lista) {
			if (cliente.getNombre().toLowerCase().startsWith(letra.toLowerCase())) {
				cliente.getDireccion().setCiudad(ciudad);
				repositorio.actualizarCliente(cliente);
				listaCambios.add(cliente);
			}
		}
		if (listaCambios.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
