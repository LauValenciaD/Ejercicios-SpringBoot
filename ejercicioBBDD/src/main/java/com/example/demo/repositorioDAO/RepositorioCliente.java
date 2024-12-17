package com.example.demo.repositorioDAO;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class RepositorioCliente implements RepositoryInterface{

	@PersistenceContext
	private EntityManager entityManager; // creamos el entityManager

	public List<Cliente> getClientes() {
		Query query = (Query) entityManager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> lista = query.getResultList();
		return lista;
	}

	public Cliente insertaCliente(Cliente cliente) {
		// es necesario @transaccional en el servicio
		entityManager.persist(cliente);
		System.out.println(cliente); // para ver los datos en consola
		return cliente;
	}

	public Cliente getCliente(Integer id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		return cliente;
	}

	public void actualizaCliente(Cliente cliente) {
			entityManager.merge(cliente);
	}
	

	

	public void deleteCliente(Cliente c) {
			entityManager.remove(c);
	}

	public List<Cliente> getClientesNombre(String nombre) {
		//Crear la consulta jpql
		String jpql = "SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre";
		
		//Crear la consulta
		Query query =(Query) entityManager.createNamedQuery(jpql, Cliente.class);
		
		//configurar el parametro
		query.setParameter("nombre", "%" + nombre + "%");
		
		//Ejecutar la consulta y obtener la lista de clientes
		return query.getResultList();
	}
}
