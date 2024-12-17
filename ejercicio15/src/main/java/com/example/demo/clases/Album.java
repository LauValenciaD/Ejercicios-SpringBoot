package com.example.demo.clases;

import java.util.List;

public class Album {
	private int id;
	private String titulo;
	private Artista artistaPrincipal;
	private int anyo;
	private List<Cancion> canciones;
	public Album(int id, String titulo, Artista artistaPrincipal, int anyo, List<Cancion> canciones) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.artistaPrincipal = artistaPrincipal;
		this.anyo = anyo;
		this.canciones = canciones;
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
	public Artista getArtistaPrincipal() {
		return artistaPrincipal;
	}
	public void setArtistaPrincipal(Artista artistaPrincipal) {
		this.artistaPrincipal = artistaPrincipal;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public List<Cancion> getCanciones() {
		return canciones;
	}
	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
}
