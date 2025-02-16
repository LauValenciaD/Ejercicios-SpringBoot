package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Curso3")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @ManyToMany(mappedBy = "cursos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Estudiante> estudiantes = new ArrayList<>();

	public Curso(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Curso() {
		super();
	}
	
    public void addEstudiante(Estudiante estudiante) {
        if (estudiantes == null) {
            estudiantes = new ArrayList<>();
        }
        estudiantes.add(estudiante);
        estudiante.getCursos().add(this);
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
