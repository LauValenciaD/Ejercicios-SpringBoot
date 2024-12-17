package com.example.demo.clases;

import java.util.List;

public class Cancion {
	private int id;
	private String titulo;
	private List<Artista> artistas;
	public Cancion(int id, String titulo, List<Artista> artistas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.artistas = artistas;
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
	public List<Artista> getArtistas() {
		return artistas;
	}
	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}
}
