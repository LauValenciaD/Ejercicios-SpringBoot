package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;
import com.example.demo.service.CursoServInt;
import com.example.demo.service.EstudianteServInter;

@SpringBootApplication
public class EjercicioBbdd15Application implements CommandLineRunner{
	//Es mas correcto llamar a la interfaz
	@Autowired
	CursoServInt cursoServ;
	@Autowired
	EstudianteServInter EstudianteServ;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioBbdd15Application.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		
	    // Crear cursos
	    Curso curso1 = new Curso("Matemáticas", "Curso avanzado de matemáticas");
	    Curso curso2 = new Curso("Programación", "Introducción a Java");

	    // Crear estudiantes
	    Estudiante estudiante1 = new Estudiante("Juan Pérez", "juan.perez@example.com");
	    Estudiante estudiante2 = new Estudiante("Ana Gómez", "ana.gomez@example.com");

	    // Asignar estudiantes a cursos
	    curso1.addEstudiante(estudiante1);
	    curso1.addEstudiante(estudiante2);
	    curso2.addEstudiante(estudiante2);
	    
	    estudiante1.getCursos().add(curso1);
	    estudiante2.getCursos().add(curso2);
	    estudiante2.getCursos().add(curso1);

	    // Persistir cursos (esto también persistirá a los estudiantes debido a la cascada)
	    cursoServ.insert(curso1);
	    cursoServ.insert(curso2);
	
        //agregar estudiante a un curso (falta)
        
        //contiene palabra
        //cursoServ.containsPalabra("matemáticas").forEach(curso -> System.out.println(curso));
        //ver cursos
        //cursoServ.getAll().forEach(curso -> System.out.println(curso));
	}
}
