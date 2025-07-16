package com.maravilla.commons.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CLIENTES")
@SequenceGenerator(name = "SEQ_CLIENTES", sequenceName = "SEQ_CLIENTES", allocationSize = 1)
public class Clientes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLENTE")
    private Long id;

    @Column(name ="NOMBRE", nullable = false)
    private String nombre;

    @Column(name ="APELLIDO", nullable = false)
    private String apellido;

    @Column(name ="EMAIL",nullable = false, unique = true)
    private String email;
    
    @Column(name ="TELEFONO", nullable = false, unique = true)
    private String telefono;
    
    @Column(name ="DIRECCION")
    private String direccion;

	public Clientes() {
	}

	public Clientes(Long id, String nombre, String apellido, String email, String telefono, String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
    
    

}
