package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pasaporte")
public class Pasaporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "numero", nullable = false, length = 255)
	private String numero;
	
	@OneToOne(mappedBy = "pasaporte", cascade = CascadeType.ALL)
	private Persona persona;

	
	public Pasaporte() {
		super();
	}
	

	public Pasaporte(String numero) {
		super();
		this.numero = numero;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Pasaporte [id=" + id + ", numero=" + numero + ", persona=" + persona + "]";
	}
	
}
