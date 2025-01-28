package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Pasaporte;
import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;
import com.example.demo.service.ServiceInter;

@SpringBootApplication
public class EjercicioBbdd18Application implements CommandLineRunner {

	@Autowired
	private ServiceInter personaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioBbdd18Application.class, args);
	}

	/**
	 *
	 */
	@Override
	public void run(String... args) throws Exception {
		// Crear personas
		Persona persona1 = new Persona("Juan Perez");
		Persona persona2 = new Persona("Ana Lopez");

		// Crear pasaportes
		Pasaporte pasaporte1 = new Pasaporte("ABC123");
		Pasaporte pasaporte2 = new Pasaporte("XYZ456");

		// insertar personas
		personaService.insertPersona(persona1);
		personaService.insertPersona(persona2);

	/*	// insertar pasaportes
		personaService.insertPasaporte(pasaporte1);
		personaService.insertPasaporte(pasaporte1);
		*/

		// Asociar pasaportes
		personaService.asignarPasaporte(persona1, pasaporte1);
		personaService.asignarPasaporte(persona2, pasaporte2);

		// Crear proyectos
		Proyecto proyecto1 = new Proyecto("Proyecto Alpha");
		Proyecto proyecto2 = new Proyecto("Proyecto Beta");

		// insertar pasaportes
		personaService.insertProyecto(proyecto1);
		personaService.insertProyecto(proyecto2);

		// Asignar proyectos a personas
		personaService.asignarProyecto(persona1, proyecto1);
		personaService.asignarProyecto(persona1, proyecto2);
		personaService.asignarProyecto(persona2, proyecto1);

		// Mostrar personas con proyectos
		personaService.getAllPersonasWithProyectos().forEach(p -> {
			System.out.println("Persona: " + p.getNombre());
			p.getProyectos().forEach(pro -> System.out.println(" - Proyecto: " + pro.getNombre()));
		});

		// Eliminar proyecto2 de persona1
		personaService.removeProyectoFromPersona(persona1, proyecto2);

	}

}
