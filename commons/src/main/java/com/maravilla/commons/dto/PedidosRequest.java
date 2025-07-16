package com.maravilla.commons.dto;

import java.util.Date;
import java.util.List;

import com.maravilla.commons.entities.ProductoPedido;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record PedidosRequest(
		@NotNull(message = "El total no puede ser null") 
		@Min(value = 1, message = "El total debe ser mayor a uno") 
		Double total,
		
		@NotNull(message = "El id del cliente es requerido") 
		Long idCliente,
		
		@NotNull(message = "La fecha de creacion no puede ser nula") 
		@PastOrPresent(message = "La fecha de creacion debe ser en pasado o presente") 
		Date fechaCreacion,
		
		@NotBlank(message = "el estado es requerido") 
		String estado,
		
		@NotNull(message = "La lsta de productos no puede estar vacia") 
		@Size(min = 1, message = "Debe hacer al menos un producto en la lista") 
		List<ProductoPedido> productos) {

}
