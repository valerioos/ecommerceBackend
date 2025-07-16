package com.maravilla.commons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClientesRequest(
		
		@NotBlank(message = "El nombre es requerido.")
		String nombre,
		
		@NotBlank(message = "El apellido es requerido.")
		String apellido,
		
		@Email
		String email,
		
		@NotNull(message = "El numero de telefono es requerido.")
		@Min(value = 1000000000L, message = "El numero de telefono debe de tener 10 digitos")
		@Max(value = 9999999999L, message = "El numero de telefono debe de tener 10 digitos")
		Long telefono,
		
		@Size(max = 100, message = "La direccion no puede exceder los 100 caracteres.")
		String direccion
		
		
		) {
	
	
}
