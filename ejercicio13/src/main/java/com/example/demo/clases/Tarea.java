package com.example.demo.clases;

import java.time.LocalDate;

public class Tarea {
	private int id;
	private String titulo;
	private String descripcion;
	private LocalDate fechaFin;
	private Estado estado;
	
    public enum Estado {
        PENDIENTE, EN_PROCESO, COMPLETA
    }

	public Tarea(int id, String titulo, String descripcion, LocalDate fechaFin, Estado estado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}



}
