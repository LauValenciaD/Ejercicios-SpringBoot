package com.example.demo.ejercicio2;


public class Alumno {
	String id;
	String nombre;
	String username;
	String password;

	public Alumno(String id, String nombre, String username, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Cliente [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + "]";
	}

	
	
}
