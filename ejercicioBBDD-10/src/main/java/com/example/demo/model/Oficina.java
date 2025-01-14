package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "oficina")
public class Oficina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "ubicacion", nullable = false, length = 255)
	private String ubicacion;
	@Column(name = "telefono", nullable = false, length = 20)
	private String telefono;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "oficna_id", referencedColumnName = "id")
	private List <Empleado> empleados;

	public Oficina(Integer id, String ubicacion, String telefono, List<Empleado> empleados) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Oficina [id=" + id + ", ubicacion=" + ubicacion + ", telefono=" + telefono + ", empleados=" + empleados
				+ "]";
	}

	public Oficina() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	


}