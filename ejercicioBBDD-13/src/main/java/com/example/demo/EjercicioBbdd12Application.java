package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Autor;
import com.example.demo.models.Libro;
import com.example.demo.service.AutorService;

@SpringBootApplication
public class EjercicioBbdd12Application implements CommandLineRunner {
	@Autowired
	private AutorService service;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioBbdd12Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	       // 1. Insertar dos autores
        Autor autor1 = new Autor("J.K. Rowling");
        Autor autor2 = new Autor("George R.R. Martin");
        service.save(autor1);
        service.save(autor2);

        // 2. Insertar un libro para cada autor
        Libro libro1 = new Libro("Harry Potter y la piedra filosofal");
        Libro libro2 = new Libro("Juego de Tronos");
        service.addLibro(libro1, autor1.getId());
        service.addLibro(libro2, autor2.getId());

        // 3. Mostrar todos los autores
        System.out.println("Autores:");
        service.getAll().forEach(System.out::println);

        // 4. Mostrar todos los libros
        System.out.println("Libros:");
        service.getAllLibros().forEach(System.out::println);

        // 5. Obtener el primer autor (por su id)
        Autor primerAutor = service.getId(autor1.getId());
        System.out.println("Primer autor: " + primerAutor);

        // 6. Actualizar el nombre del primer autor
        primerAutor.setNombre("Joanne Rowling");
        service.save(primerAutor);

        // 7. Mostrar el autor actualizado
        System.out.println("Autor actualizado: " + service.getId(autor1.getId()));

        // 8. Buscar autores cuyo nombre contiene 'RowLing'
        System.out.println("Autores que contienen 'RowLing':");
        service.buscarPorNombre("RowLing").forEach(System.out::println);

        // 9. Actualizar el título del segundo libro
        service.updateLibro(2, "Canción de Hielo y Fuego");

        // 10. Mostrar los libros actualizados
        System.out.println("Libros actualizados:");
        service.getAllLibros().forEach(System.out::println);

        // 11. Eliminar el segundo autor
        service.removeAutor(autor2.getId());

        // 12. Mostrar todos los autores restantes
        System.out.println("Autores después de eliminar:");
        service.getAll().forEach(System.out::println);
    }


	}


