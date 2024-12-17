package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repositorioDAO.RepositorioCliente;
import com.example.demo.repositorioDAO.RepositoryInterface;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicio implements ServiceInterface {

	@Autowired
	private RepositoryInterface repositorio;

	public List<Cliente> getClientes() {
		return repositorio.getClientes();
	}

	@Transactional
	public Cliente insertaCliente(Cliente cl) {
		return repositorio.insertaCliente(cl);
	}

	public Cliente getCliente(Integer id) {
		return repositorio.getCliente(id);
	}
	@Transactional
	public void actualizaCliente(Cliente cliente) {
		 repositorio.actualizaCliente(cliente);
	}
	
	@Transactional
	public void deleteCliente(Cliente cliente) {
		repositorio.deleteCliente(cliente);
	}

	public List<Cliente> getClientesNombre(String nombre) {
		return repositorio.getClientesNombre(nombre);
	}

}
