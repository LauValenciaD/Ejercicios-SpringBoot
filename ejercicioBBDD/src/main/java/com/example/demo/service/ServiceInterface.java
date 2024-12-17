package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Cliente;


public interface ServiceInterface {

	public List<Cliente> getClientes();

	public Cliente insertaCliente(Cliente cl);

	public Cliente getCliente(Integer id);

	public void actualizaCliente(Cliente cliente);

	public void deleteCliente(Cliente cliente);

	public List<Cliente> getClientesNombre(String nombre);

}
