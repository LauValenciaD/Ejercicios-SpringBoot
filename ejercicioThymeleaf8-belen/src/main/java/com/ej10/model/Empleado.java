package com.ej10.model;

import jakarta.persistence.*;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String puesto;

   
	@Column(nullable = false, unique = true)
    private String email;

    public Empleado(String nombre, String puesto, String email) {
		super();		
		this.nombre = nombre;
		this.puesto = puesto;
		this.email = email;	
	}

    
    
    public Empleado() {
		super();
	}



	// Getters y setters
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



	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", puesto=" + puesto + ", email=" + email + "]";
	}

   
}
