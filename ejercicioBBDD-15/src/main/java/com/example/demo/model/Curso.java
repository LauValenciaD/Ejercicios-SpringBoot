package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@ManyToMany(mappedBy = "cursos")
	private List<Estudiante> estudiantes = new ArrayList<>();

	public Curso(String nombre, String email, List<Estudiante> estudiantes) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.estudiantes = estudiantes;
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", email=" + email + ", estudiantes=" + estudiantes + "]";
	}
	
	
}
