package com.example.demo.repositorioDAO;

import java.util.List;

import com.example.demo.model.Cliente;

public interface RepositoryInterface {

	public List<Cliente> getClientes();

	public Cliente insertaCliente(Cliente cliente);

	public Cliente getCliente(Integer id);

	public void actualizaCliente(Cliente cliente);

	public void deleteCliente(Cliente c);

	public List<Cliente> getClientesNombre(String nombre);
}
