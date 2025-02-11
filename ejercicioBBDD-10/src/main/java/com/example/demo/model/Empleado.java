package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	@Column(name = "puesto", nullable = false, length = 100)
	private String puesto;
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", puesto=" + puesto + ", email=" + email + "]";
	}
	

	public Empleado(String nombre, String puesto, String email) {
		super();
		this.nombre = nombre;
		this.puesto = puesto;
		this.email = email;
	}


	public Empleado() {
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
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
