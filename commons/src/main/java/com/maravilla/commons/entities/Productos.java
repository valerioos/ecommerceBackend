package com.maravilla.commons.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCTOS")
public class Productos {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCTOS")
	@SequenceGenerator(name = "SEQ_PRODUCTOS", sequenceName = "SEQ_PRODUCTOS", allocationSize = 1)
	@Column(name = "ID_PRODUCTO")
    private Long id;
	
	@Column(name = "NOMBRE")
	@NotBlank(message = "El nombre del producto es requerido.")
	private String nombre;

    @Column(name = "DESCRIPCION")
	@NotBlank(message = "La descripcion del producto es requerido.")
	private String descripcion;

    @Column(name = "PRECIO")
	@NotNull(message = "El precio del producto es requerido.")
	@DecimalMin("0.01")
	private float precio;
    
    @Column(name = "STOCK")
	@NotNull(message = "El stock del producto es requerido.")
	@Min(1)
	private int stock;

	public Productos() {
	}

	public Productos(Long id,String nombre,
			String descripcion,
			float precio,
			int stock) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
