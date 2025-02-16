package com.ej15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ej15.model.Curso;
import com.ej15.model.Estudiante;
import com.ej15.service.CursoService;
import com.ej15.service.EstudianteService;

@SpringBootApplication
public class EjercicioBbdd15BelenApplication implements CommandLineRunner{
	//Es mas correcto llamar a la interfaz
	@Autowired
	CursoService cursoServ;
	@Autowired
	EstudianteService EstudianteServ;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioBbdd15BelenApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		
	    // Crear cursos
	     //Curso curso1 = new Curso("Matemáticas", "Curso avanzado de matemáticas");
	    //Curso curso2 = new Curso("Programación", "Introducción a Java");

	    // Crear estudiantes
	    //Estudiante estudiante1 = new Estudiante("Juan Pérez", "juan.perez@example.com");
	    //Estudiante estudiante2 = new Estudiante("Ana Gómez", "ana.gomez@example.com");
		
		Curso curso1 = new Curso();
		Curso curso2 = new Curso();
		curso1.setNombre("Matemáticas");
		curso1.setDescripcion("Curso avanzado de matemáticas");
		
		Estudiante estudiante1 = new Estudiante();
		estudiante1.setNombre("Juan Pérez");
		estudiante1.setEmail("juan.perez@example.com");

	    // Asignar estudiantes a cursos
	    curso1.addEstudiante(estudiante1);
	    estudiante1.getCursos().add(curso1);

	    // Persistir cursos (esto también persistirá a los estudiantes debido a la cascada)
	    cursoServ.createCurso(curso1);

	
	}
}
