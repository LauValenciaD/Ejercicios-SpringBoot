package com.ej15.model;

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
import jakarta.persistence.OneToMany;

@Entity(name="curso2")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @ManyToMany(mappedBy = "cursos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Estudiante> estudiantes = new ArrayList<>();

    public void addEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        estudiante.getCursos().add(this);
    }

    public void removeEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
        estudiante.getCursos().remove(this);
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

 
}
