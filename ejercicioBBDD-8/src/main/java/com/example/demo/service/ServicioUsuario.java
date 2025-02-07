package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Perfil;
import com.example.demo.models.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;

import jakarta.transaction.Transactional;

@Service
public class ServicioUsuario implements ServiceInterface{
	@Autowired
	private UsuarioRepositorio repositorio;
	@Override
	public List<Usuario> getUsuarios() {
		return repositorio.getUsuarios();
	}

	@Override
	@Transactional
	public void insertaUsuario(Usuario usuario) {
		repositorio.insert(usuario);
		
	}

	@Override
	public Usuario getUsuario(Integer id) {
		return repositorio.getId(id);
	}

	@Override
	@Transactional
	public boolean actualizaUsuario(Usuario usuario, Integer id) {
		Usuario encontrado = repositorio.getId(id);
		if (encontrado == null) {
			return false;
		} else {
//			cliente.setId(id); // Seteamos el ID recibido al cliente para no tener que ponerlo en el body
//			cliente.getDireccion().setId(encontrado.getDireccion().getId());
			repositorio.actualizar(usuario);
			return true;
		}
	}

	@Override
	@Transactional
	public boolean patchUsuario(Usuario usuario, Integer id) {
		Usuario encontrado = repositorio.getId(id);
		if (encontrado == null) {
			return false;
		} else {
			if (usuario.getNombre() != null) {
				encontrado.setNombre(usuario.getNombre());
			}
			if (usuario.getEmail() != null) {
				encontrado.setEmail(usuario.getEmail());
			}
			
			if (usuario.getPerfil() != null) {
				encontrado.setPerfil(usuario.getPerfil());
			}
			repositorio.actualizar(encontrado);
			return true;
	} }

	@Override
	@Transactional
	public boolean deleteUsuario(Integer id) {
		Usuario encontrado = repositorio.getId(id);
		if (encontrado == null) {
			return false;
		} else {
			repositorio.delete(encontrado);
			return true;
		}
	}

	@Override
	public Perfil obtenerPerfil(Integer id) {
		Usuario usuario = repositorio.getId(id);
		return usuario.getPerfil();
	}


	@Override
	@Transactional
	public void actualizarPerfil(Integer id, Perfil nuevoPerfil) {

		Usuario usuario = repositorio.getId(id);
		if (usuario != null) {
			if (nuevoPerfil != null) {
				nuevoPerfil.setId(usuario.getPerfil().getId());
				usuario.setPerfil(nuevoPerfil);
				repositorio.actualizar(usuario);

			}
		}

	}

	@Override
	@Transactional
	public void actualizarDisponible(Integer id) {
		Usuario usuario = repositorio.getId(id);
		usuario.getPerfil().setEstado("DISPONIBLE");
	}


	@Override
	public List<Usuario> usuariosBiografia(String palabra) {
		List<Usuario> lista = repositorio.usuariosBiografia(palabra);
		return lista;

	}

	@Override
	public Usuario obtenerDisponible() {
		return repositorio.obtenerDisponible();
	}

	@Override
	public List<Usuario> obtenerNoDisponible() {
		return repositorio.obtenerNoDisponible();
	}

}
