package com.maravilla.commons.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductosRequest(
		
		@NotBlank(message = "El nombre del producto es requerido.")
		String nombre,
		
		@NotBlank(message = "La descripcion del producto es requerido.")
		String descripcion,
		
		@NotNull(message = "El precio del producto es requerido.")
		@DecimalMin(value = "0.01", message = "El precio no puede ser 0.")
		float precio,
		
		@NotNull(message = "El stock del producto es requerido.")
		@Min(value = 1, message = "El stock no puede ser igual o mayor a 0.")
		int stock
		
) {}
