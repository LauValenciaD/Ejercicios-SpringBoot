package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ejercicio9.Alumno;
import com.example.demo.ejercicio9.Direccion;

@RestController
@RequestMapping("/alumnos")
public class Controladores2 {
	private ArrayList<Alumno> listaAlumnos = new ArrayList<>();

	public Controladores2() {
		Alumno alumno1 = new Alumno("1", "Juan", "juanito@gmail", "daw", "2",
				new Direccion("marte", "61233", "sevilla"));
		Alumno alumno2 = new Alumno("2", "Pepe", "pepito@gmail", "dam", "2",
				new Direccion("jupiter", "51233", "zamora"));
		Alumno alumno3 = new Alumno("3", "Maria", "maria@gmail", "dam", "2",
				new Direccion("luna", "41233", "valencia"));
		Alumno alumno4 = new Alumno("4", "Carmen", "carmencita@gmail", "daw", "2",
				new Direccion("peru", "21233", "cadiz"));
		Alumno alumno5 = new Alumno("5", "Gema", "juanito@gmail", "daw", "2",
				new Direccion("urano", "61233", "sevilla"));
		listaAlumnos.add(alumno1);
		listaAlumnos.add(alumno2);
		listaAlumnos.add(alumno3);
		listaAlumnos.add(alumno4);
		listaAlumnos.add(alumno5);
	}

	@GetMapping // borrado (/clientes)
	public ResponseEntity<ArrayList> verAlumnos() {
		// return new ResponseEntity<>(listaAlumnos, HttpStatus.OK);
		return ResponseEntity.ok(listaAlumnos); // la manera de Belen
	}

	@GetMapping("/{username}") // ejercicio 2
	public ResponseEntity<Alumno> getEmail(@PathVariable String email) {
		for (Alumno alumno : listaAlumnos) { // hacer un for each para ver todos los datos del cliente
			if (alumno.getEmail().equalsIgnoreCase(email)) // si coincide devuelve el cliente
			{
				return ResponseEntity.ok(alumno);
			}
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping // añadir un nuevo cliente a la lista de clientes
	public ResponseEntity<Alumno> postAlumno(@RequestBody Alumno alumno) { // en el postman escribir en el body raw los
																			// datos del cliente como en el JSON
		listaAlumnos.add(alumno);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Alumno> putAlumno(@RequestBody Alumno alumno, @PathVariable String id) // busca a un cliente
																									// por id y lo
																									// actualiza
	{
		for (Alumno alumno1 : listaAlumnos) { // hacer un for each para ver todos los datos del cliente
			if (alumno1.getId().equalsIgnoreCase(id)) // si coincide devuelve el cliente
			{
				alumno1.setNombre(alumno.getNombre());
				alumno1.setEmail(alumno.getEmail());
				alumno1.setEdad(alumno.getEdad());
				alumno1.setCurso(alumno.getCurso());

				alumno1.setDirection(alumno.getDirection()); // nueva linea

				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Alumno> deleteAlumno(@PathVariable String id) {
		Iterator<Alumno> iterator = listaAlumnos.iterator(); // para borrar NO usar for each porque puede dar error
		while (iterator.hasNext()) {
			Alumno alumno = iterator.next();
			if (alumno.getId().equalsIgnoreCase(id)) {
				iterator.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PatchMapping
	public ResponseEntity<Alumno> patchCliente(@RequestBody Alumno modif) {
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getId() == modif.getId()) {

				if (modif.getNombre() != null) {
					System.out.println("nombre");
					alumno.setNombre(modif.getNombre());
				}
				if (modif.getEmail() != null) {
					System.out.println("email");
					alumno.setEmail(modif.getEmail());
				}
				if (modif.getEdad() != null) {
					System.out.println("edad");
					alumno.setEdad(modif.getEdad());
				}
				if (modif.getCurso() != null) {
					System.out.println("curso");
					alumno.setCurso(modif.getCurso());
				}
				if (modif.getDirection() != null) {
					alumno.setDirection(modif.getDirection()); // nueva línea
				}

				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/direcciones")
	public ResponseEntity<ArrayList> getDirecciones() {
		ArrayList<Direccion> listaDirecciones = new ArrayList<>();
		for (Alumno alumno : listaAlumnos) {
			listaDirecciones.add(alumno.getDirection()); // añadir direcciones a la lista
		}
		return ResponseEntity.ok(listaDirecciones); // la manera de Belen
	}

	@GetMapping("/direcciones/{codigoP}") // cuidado tiene que tener el mismo nombre que el atributo del pathvariable
	public ResponseEntity<ArrayList> obtenerDireccionesPorCodigoPostal(@PathVariable String codigoP) {
		ArrayList<Direccion> listaDireccionesCP = new ArrayList<>();
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getDirection().getCodigoPostal().equalsIgnoreCase(codigoP)) {
				listaDireccionesCP.add(alumno.getDirection()); // añadir direcciones a la lista
			}
		}
		if (listaDireccionesCP.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(listaDireccionesCP);
		}
	}
	@GetMapping("/direcciones/ciudad/{ciudad}") // cuidado tiene que tener el mismo nombre que el atributo del pathvariable
	public ResponseEntity<Integer> contarAlumnosPorCiudad(@PathVariable String ciudad) {
		int contador = 0;
		for (Alumno alumno : listaAlumnos) {
			if (alumno.getDirection().getCiudad().equalsIgnoreCase(ciudad)) {
					contador++;
			}
		}
		if (contador == 0) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(contador);
		}
	}
}
