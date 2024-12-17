package com.example.demo.ejercicio9;


public class Alumno {
	private String id;
	private String nombre;
	private String email;
	private String edad;
	private String curso;
	private Direccion direction;
	public Alumno(String id, String nombre, String email, String edad, String curso, Direccion direction) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.curso = curso;
		this.direction = direction;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Direccion getDirection() {
		return direction;
	}
	public void setDirection(Direccion direction) {
		this.direction = direction;
	}

}
