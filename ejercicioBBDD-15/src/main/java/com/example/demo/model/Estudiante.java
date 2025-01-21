package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estudiante")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "estudiante_curso",
		joinColumns = {@JoinColumn(name = "id_estudiante") },
		inverseJoinColumns = {@JoinColumn(name = "id_curso") })
	//para que no se cree nulo supongo?
	private List<Curso> cursos = new ArrayList<>();

	public Estudiante(String nombre, String email, List<Curso> cursos) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.cursos = cursos;
	}

	public Estudiante() {
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", email=" + email + ", cursos=" + cursos + "]";
	}
	
	
	}
		
