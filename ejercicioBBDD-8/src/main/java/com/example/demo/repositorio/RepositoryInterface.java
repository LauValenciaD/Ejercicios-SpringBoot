package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.models.Usuario;

public interface RepositoryInterface {
	List<Usuario> getUsuarios();

	Usuario getId(Integer id);

	void insert(Usuario usuario);

	void actualizar(Usuario usuario);

	void delete(Usuario usuario);

	List<Usuario> usuariosBiografia(String palabra);

	Usuario obtenerDisponible();

	List<Usuario> obtenerNoDisponible();

}
