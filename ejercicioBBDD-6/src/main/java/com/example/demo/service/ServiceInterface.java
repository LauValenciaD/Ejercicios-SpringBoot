package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Cliente;


public interface ServiceInterface {
	
	List<Cliente> getClientes();
	
	public void insertaCliente(Cliente cl);

	public Cliente getCliente(Integer id);

	public boolean actualizaCliente(Cliente cliente, Integer id);
	
	public boolean patchCliente(Cliente cliente, Integer id);
	
	public boolean deleteCliente(Integer id);
	
}