package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.servicio.EmpleadoServicio;
import com.example.demo.servicio.OficinaServicio;

@SpringBootApplication
public class EjercicioBbdd10Application implements CommandLineRunner{
	
	@Autowired
	private EmpleadoServicio empleadoServicio;
	@Autowired
	private OficinaServicio oficinaServicio;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioBbdd10Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// aqui lanzar pruebas para ver si funciona, Belen dice que podemos saltarnos el controller
		//crear 2 objetos de la clase oficina e insertarlos
	}

}
