package com.maravilla.commons.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "PEDIDOS")
public class Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIDOS")
	@SequenceGenerator(name = "SEQ_PEDIDOS", sequenceName = "SEQ_PEDIDOS", allocationSize = 1)
	@Column(name = "ID_PEDIDO")
	private Long id;

	@Column(name = "ID_CLIENTE", nullable = false)
	private Long idCliente;

	@Column(name = "TOTAL", nullable = false)
	private Double Total;

	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "ESTADO")
	private String estado;

	@ElementCollection
	@CollectionTable(name = "PEDIDO_PRODUCTO", joinColumns = @JoinColumn(name = "ID_PEDIDO"))
	private List<ProductoPedido> productos;

	public Pedidos(Long id, Long idCliente, Double total, Date fechaCreacion, String estado,
			List<ProductoPedido> productos) {
		this.id = id;
		this.idCliente = idCliente;
		Total = total;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.productos = productos;
	}

	public Pedidos() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Double getTotal() {
		return Total;
	}

	public void setTotal(Double total) {
		Total = total;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ProductoPedido> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoPedido> productos) {
		this.productos = productos;
	}
	
}
