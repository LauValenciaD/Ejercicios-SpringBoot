package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;
	@Column(name = "descripcion", nullable = false, length = 255)
	private String descripcion;
	
	@ManyToMany(mappedBy = "cursos", fetch = FetchType.EAGER)
	private List<Estudiante> estudiantes = new ArrayList<>();

	public Curso(String nombre, String descripcion, List<Estudiante> estudiantes) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		//permite evitar problemas si hay lista o si es null
		this.estudiantes = (estudiantes != null) ? estudiantes : new ArrayList<>();
	}

	public Curso() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return descripcion;
	}

	public void setEmail(String email) {
		this.descripcion = email;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	//Para evitar el bucle infinito de ToString
	@Override
	public String toString() {
	    return "Curso{" +
	            "nombre='" + nombre + '\'' +
	            ", descripcion='" + descripcion + '\'' +
	            ", estudiantes=" + estudiantes.stream().map(Estudiante::getNombre).toList() +
	            '}';
	}

	
	
}
