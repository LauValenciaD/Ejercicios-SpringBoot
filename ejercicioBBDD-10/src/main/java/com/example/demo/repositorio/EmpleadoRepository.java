package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class EmpleadoRepository implements EmpleadoRepositoryInterface{
	@PersistenceContext
	private EntityManager entityManager; // creamos el entityManager
	@Override
	public void insertEmpleado(Empleado empleado) {
		entityManager.persist(empleado);
		
	}

	@Override
	public List<Empleado> getEmpleados() {
		return entityManager.createQuery("FROM Empleado e", Empleado.class).getResultList();
	}

	@Override
	public Empleado getEmpleado(Integer id) {
		return entityManager.find(Empleado.class, id);
	}

	@Override
	public void patchEmpleado(Empleado empleado) {
		entityManager.merge(empleado);
		
	}

	@Override
	public void deleteEmpleado(Empleado empleado) {
			entityManager.remove(empleado);
		}		

	@Override
	public List<Empleado> getEmpleadosPuestos(String puesto) {
		return entityManager.createQuery("FROM Empleado e WHERE e.puesto = :puesto", Empleado.class).setParameter("puesto", puesto).getResultList();
	}

}
