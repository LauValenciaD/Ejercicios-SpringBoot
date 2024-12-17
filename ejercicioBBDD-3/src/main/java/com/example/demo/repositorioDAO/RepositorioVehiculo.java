package com.example.demo.repositorioDAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class RepositorioVehiculo {
	@PersistenceContext
	private EntityManager entityManager; // creamos el entityManager

	public List<Vehiculo> getVehiculos() {
		Query query = (Query) entityManager.createQuery("select c from Vehiculo c", Vehiculo.class);
		List<Vehiculo> lista = query.getResultList();
		return lista;
	}

	public Vehiculo insertaVehiculo(Vehiculo vehiculo) {
		// es necesario @transaccional en el servicio
		entityManager.persist(vehiculo);
		System.out.println(vehiculo); // para ver los datos en consola
		return vehiculo;
	}

	public Vehiculo getVehiculo(Integer id) {
		Vehiculo Vehiculo = entityManager.find(Vehiculo.class, id);
		return Vehiculo;
	}

	public void actualizaVehiculo(Vehiculo vehiculo) {
			entityManager.merge(vehiculo);
	}
	

	

	public void deleteVehiculo(Vehiculo v) {
			entityManager.remove(v);
	}

//	public List<Vehiculo> getVehiculosNombre(String nombre) {
//		//Crear la consulta jpql
//		String jpql = "SELECT c FROM Vehiculos c WHERE c.nombre LIKE :nombre";
//		
//		//Crear la consulta
//		Query query =(Query) entityManager.createNamedQuery(jpql, Vehiculo.class);
//		
//		//configurar el parametro
//		query.setParameter("nombre", "%" + nombre + "%");
//		
//		//Ejecutar la consulta y obtener la lista de Vehiculos
//		return query.getResultList();
//	}
}
