package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Repository
public class ClienteRepositorio implements RepositoryInterface {
	@PersistenceContext
	private EntityManager entityManager; // creamos el entityManager

	@Override
	public List<Cliente> getClientes() {
		Query query = (Query) entityManager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> lista = query.getResultList();
		return lista;
	}

	@Override
	public Cliente get(int id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		return cliente;
	}

	@Override
	public void insert(Cliente cliente) {
		entityManager.persist(cliente);
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		entityManager.merge(cliente);
	}

	@Override
	public void delete(Cliente c) {
		entityManager.remove(c);

	}

	@Override
	public List<Cliente> buscarPorCiudad(String ciudad) {
		//Crear la consulta jpql
		 String jpql = "SELECT c FROM Cliente c JOIN c.direccion d WHERE d.ciudad LIKE :ciudad";
		
		//Crear la consulta
		Query query =(Query) entityManager.createQuery(jpql, Cliente.class); // Cambié createNamedQuery por createQuery porque estás usando una consulta JPQL directa y no una consulta nombrada previamente en las entidades.
		
		//configurar el parametro
		query.setParameter("ciudad", "%" + ciudad + "%");
		
		//Ejecutar la consulta y obtener la lista de clientes
		return query.getResultList();
	}

}
