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
		
		// Crear la lista de estudiantes para los cursos
        List<Estudiante> estudiantesCurso1 = new ArrayList<>();
        List<Estudiante> estudiantesCurso2 = new ArrayList<>();

        // Crear cursos (vacíos inicialmente)
        Curso curso1 = new Curso("Matemáticas", "Curso avanzado de matemáticas", estudiantesCurso1);
        Curso curso2 = new Curso("Programación", "Introducción a Java", estudiantesCurso2);

        // Crear la lista de cursos para los estudiantes
        List<Curso> cursosEstudiante1 = new ArrayList<>(Arrays.asList(curso1, curso2));
        List<Curso> cursosEstudiante2 = new ArrayList<>(Arrays.asList(curso2));

        // Crear estudiantes y asignarles los cursos
        Estudiante estudiante1 = new Estudiante("Juan Pérez", "juan.perez@example.com", cursosEstudiante1);
        Estudiante estudiante2 = new Estudiante("Ana Gómez", "ana.gomez@example.com", cursosEstudiante2);

        // Agregar estudiantes a los cursos correspondientes
        curso1.getEstudiantes().add(estudiante1);
        curso2.getEstudiantes().add(estudiante1);
        curso2.getEstudiantes().add(estudiante2);

        // Imprimir información
        System.out.println("Información de los cursos:");
        System.out.println(curso1);
        System.out.println(curso2);

        System.out.println("\nInformación de los estudiantes:");
        System.out.println(estudiante1);
        System.out.println(estudiante2);
        
        //insertar curso
        cursoServ.insert(curso1);
        cursoServ.insert(curso2);
        //agregar estudiante a un curso (falta)
        
        //contiene palabra
        cursoServ.containsPalabra("matemáticas").forEach(curso -> System.out.println(curso));
        //ver cursos
        cursoServ.getAll().forEach(curso -> System.out.println(curso));
	}
}
