package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Empleado;
@Service
public interface EmpleadoServicioInterface {
	//crear un empleado
		void insertEmpleado (Empleado empleado);
		
		//consultar empleados
		List<Empleado> getEmpleados ();
		
		//consultar por id
		Empleado getEmpleado (Integer id);
		
		//actualizar info
		void patchEmpleado (Empleado empleado);
		
		//eliminar empleado
		boolean deleteEmpleado (Integer id);
		
		//listar empleados por puesto
		List<Empleado> getEmpleadosPuestos (String puesto);
}
