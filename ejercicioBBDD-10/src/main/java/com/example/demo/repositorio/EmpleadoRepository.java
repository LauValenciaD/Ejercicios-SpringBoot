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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empleado> getEmpleados() {
		return entityManager.createQuery("FROM Empleado e", Empleado.class).getResultList();
	}

	@Override
	public Empleado getEmpleado(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Empleado.class, id);
	}

	@Override
	public void patchEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmpleado(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Empleado> getEmpleadosPuestos(String puesto) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("FROM Empleado e WHERE e.puesto = :puesto", Empleado.class).setParameter("puesto", puesto).getResultList();
	}

}
