package com.example.demo.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Empleado;
import com.example.demo.model.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class OficinaRepository implements OficinaRepositoryInterface {
	@PersistenceContext
	private EntityManager entityManager; // creamos el entityManager

	@Override
	public void insertOficina(Oficina oficina) {
		entityManager.persist(oficina);

	}

	@Override
	public List<Oficina> getOficinas() {
		return entityManager.createQuery("FROM Oficina o", Oficina.class).getResultList();
	}

	@Override
	public Oficina getOficinaId(Integer id) {
		return entityManager.find(Oficina.class, id);
	}

	@Override
	public void deleteOficina(Oficina oficina) {
		entityManager.remove(oficina);

	}

	// Contar empleados de una oficina
	/*
	 * public Integer contarEmpleados(Integer id) { String jpql =
	 * "SELECT COUNT(e) FROM Empleado e WHERE e.oficina.id = :id"; Long count =
	 * (Long) entityManager.createQuery(jpql) .setParameter("id", id)
	 * .getSingleResult(); return count.intValue(); }
	 */

	// Devolver un mapa con id de oficina y número de empleados
	/*
	 * public Map<Integer, Integer> mapaOficina() { String jpql =
	 * "SELECT o.id, COUNT(e) FROM Oficina o LEFT JOIN o.empleados e GROUP BY o.id";
	 * List<Object[]> results = entityManager.createQuery(jpql).getResultList();
	 * Map<Integer, Integer> oficinaEmpleadoMap = new HashMap<>(); for (Object[]
	 * result : results) { Integer oficinaId = (Integer) result[0]; Long
	 * empleadoCount = (Long) result[1]; oficinaEmpleadoMap.put(oficinaId,
	 * empleadoCount.intValue()); } return oficinaEmpleadoMap; }
	 */
	// Devolver oficinas con más de N empleados
	/*
	 * public List<Oficina> masXempleados(Integer numero) { String jpql =
	 * "SELECT o FROM Oficina o WHERE SIZE(o.empleados) > :numero"; return
	 * entityManager.createQuery(jpql, Oficina.class) .setParameter("numero",
	 * numero) .getResultList(); }
	 */

	// Actualizar el teléfono de una oficina dado el id de un empleado
	@Transactional
	public void actualizarTelf(Integer id, String telefono) {
		Empleado empleado = entityManager.find(Empleado.class, id);
		if (empleado != null) {
			// buscar la oficina asociada
			String jpql = "SELECT o FROM Oficina o JOIN o.empleados e WHERE e.id = :empleadoId";
			Oficina oficina = (Oficina) entityManager.createQuery(jpql).setParameter("empleadoId", id)
					.getSingleResult();
			if (oficina != null) {
				oficina.setTelefono(telefono);
				entityManager.merge(oficina);
				System.out.println("Telefono de la oficina actualizado");
			}
		} else {
			System.out.println("La oficina no se encontró.");
		}
	}
}
