package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Empleado;
import com.example.demo.repositorio.EmpleadoRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpleadoServicio implements EmpleadoServicioInterface {
	@Autowired
	private EmpleadoRepository repositorio;

	@Override
	@Transactional
	public void insertEmpleado(Empleado empleado) {
		repositorio.insertEmpleado(empleado);

	}

	@Override
	public List<Empleado> getEmpleados() {
		return repositorio.getEmpleados();
	}

	@Override
	public Empleado getEmpleado(Integer id) {
		return repositorio.getEmpleado(id);
	}

	@Override
	public void patchEmpleado(Empleado empleado) {
		Empleado encontrado = repositorio.getEmpleado(empleado.getId());
		if (encontrado == null) {
		} else {
			if (empleado.getNombre() != null) {
				encontrado.setNombre(empleado.getNombre());
			}
			if (empleado.getEmail() != null) {
				encontrado.setEmail(empleado.getEmail());
			}

			if (empleado.getPuesto() != null) {
				encontrado.setPuesto(empleado.getPuesto());
			}
			repositorio.patchEmpleado(encontrado);

		}
	}

	@Override
	@Transactional // se puede hacer boolean o void
	public boolean deleteEmpleado(Integer id) {
		Empleado encontrado = repositorio.getEmpleado(id);
		if (encontrado == null) {
			return false;
		} else {
			repositorio.deleteEmpleado(encontrado);
			return true;
		}
	}

	@Override
	public List<Empleado> getEmpleadosPuestos(String puesto) {
		return repositorio.getEmpleadosPuestos(puesto);
	}
}