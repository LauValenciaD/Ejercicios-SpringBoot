package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.model.Empleado;

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
	void deleteEmpleado (Integer id);
	
	//listar empleados por puesto
	List<Empleado> getEmpleadosPuestos (String puesto);
}
