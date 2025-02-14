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
		// TODO Auto-generated method stub
		List<Libro> lista = new ArrayList<>();
		Autor autorUno = new Autor();
		autorUno.setNombre("Pepito");
		Libro libroUno = new Libro();
		libroUno.setTitulo("Quijote");
		lista.add(libroUno);
		autorUno.setLibros(lista);
		service.insertAutor(autorUno);
		System.out.println("ver autores");
		service.getAutores().forEach(autor -> System.out.println(autor));

		System.out.println("Agregar y ver libro de pepito");
		Libro libroDos = new Libro();
		libroDos.setTitulo("Mártir");
		autorUno.getLibros().add(libroDos);
		service.patch(autorUno);
		service.getAutores().forEach(autor -> System.out.println(autor));

	}

}
