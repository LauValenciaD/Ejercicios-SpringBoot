package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Usuario obtenerPerfil(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Usuario actualizarPerfil(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Usuario actualizarDisponible(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscarPorEdad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerDisponible() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> obtenerNoDisponible() {
		// TODO Auto-generated method stub
		return null;
	}

}
