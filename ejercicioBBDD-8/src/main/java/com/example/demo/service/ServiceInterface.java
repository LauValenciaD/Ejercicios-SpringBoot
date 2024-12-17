package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Usuario;

public interface ServiceInterface {
	List<Usuario> getUsuarios();

	public void insertaUsuario(Usuario usuario);

	public Usuario getUsuario(Integer id);

	public boolean actualizaUsuario(Usuario usuario, Integer id);

	public boolean patchUsuario(Usuario usuario, Integer id);

	public boolean deleteUsuario(Integer id);
	
	Usuario obtenerPerfil(Integer id);
	
	Usuario actualizarPerfil (Integer id);
	
	Usuario actualizarDisponible (Integer id);
	
	List<Usuario> buscarPorEdad();

	Usuario obtenerDisponible();

	List<Usuario> obtenerNoDisponible();

}
