package com.example.demo.clases;

import java.util.ArrayList;

public class Libro {
	private String id;
	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	private Integer añoPublicacion;
	private String[] genero;
	public Libro(String id, String titulo, String autor, String editorial, String isbn, Integer añoPublicacion,
			String[] genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.añoPublicacion = añoPublicacion;
		this.genero = genero;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getAñoPublicacion() {
		return añoPublicacion;
	}
	public void setAñoPublicacion(Integer añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}
	public String[] getGenero() {
		return genero;
	}
	public void setGenero(String[] genero) {
		this.genero = genero;
	}
	
	
}