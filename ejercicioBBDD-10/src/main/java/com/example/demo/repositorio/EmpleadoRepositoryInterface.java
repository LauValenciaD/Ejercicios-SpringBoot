package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Empleado;

@Repository //aparentemente tiene que ser asi
public interface EmpleadoRepositoryInterface {
	//crear un empleado
	void insertEmpleado (Empleado empleado);
	
	//consultar empleados
	List<Empleado> getEmpleados ();
	
	//consultar por id
	Empleado getEmpleado (Integer id);
	
	//actualizar info
	void patchEmpleado (Empleado empleado);
	
	//eliminar empleado
	void deleteEmpleado (Empleado empleado);
	
	//listar empleados por puesto
	List<Empleado> getEmpleadosPuestos (String puesto);
}
