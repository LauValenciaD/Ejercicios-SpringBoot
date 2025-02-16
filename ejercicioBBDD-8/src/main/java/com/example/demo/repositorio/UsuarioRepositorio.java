package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
@Repository
public class UsuarioRepositorio implements RepositoryInterface{
	@PersistenceContext
	private EntityManager entityManager; // creamos el entityManager
	@Override
	public List<Usuario> getUsuarios() {
		Query query = (Query) entityManager.createQuery("select u from Usuario u", Usuario.class);
		List<Usuario> lista = query.getResultList();
		return lista;
	}

	@Override
	public Usuario getId(Integer id) {
		Usuario Usuario = entityManager.find(Usuario.class, id);
		return Usuario;
	}

	@Override
	public void insert(Usuario usuario) {
		entityManager.persist(usuario);
		
	}

	@Override
	public void actualizar(Usuario usuario) {
		entityManager.merge(usuario);
		
	}

	@Override
	public void delete(Usuario usuario) {
		entityManager.remove(usuario);
		
	}

	@Override
	public List<Usuario> usuariosBiografia(String palabra) {
	      String hql = "SELECT u FROM Usuario u WHERE u.perfil.bio LIKE :palabra";
	        TypedQuery<Usuario> query = entityManager.createQuery(hql, Usuario.class);
	        query.setParameter("palabra", "%" + palabra + "%");
	        return query.getResultList();

	}

	@Override
	public Usuario obtenerDisponible() {
		 String hql = "SELECT u FROM Usuario u WHERE u.perfil.estado = :estado";
         TypedQuery<Usuario> query = entityManager.createQuery(hql, Usuario.class);
         query.setParameter("estado", "DISPONIBLE");
         
         List<Usuario> usuarios = query.getResultList();
         return usuarios.isEmpty() ? null : usuarios.get(0);

	}

	@Override
	public List<Usuario> obtenerNoDisponible() {
		String hql = "SELECT u FROM Usuario u WHERE u.perfil.estado = :estado";
        return entityManager.createQuery(hql, Usuario.class).setParameter("estado", "NO DISPONIBLE").getResultList();

	}

}
