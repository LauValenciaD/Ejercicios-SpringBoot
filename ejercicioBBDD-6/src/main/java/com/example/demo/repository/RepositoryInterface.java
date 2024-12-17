package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.Cliente;

public interface RepositoryInterface {
	List<Cliente> getClientes();
	Cliente get(int id);
	void insert(Cliente cliente);
	void actualizarCliente (Cliente cliente);
	void delete(Cliente c);
	List<Cliente> buscarPorCiudad(String ciudad);
}
