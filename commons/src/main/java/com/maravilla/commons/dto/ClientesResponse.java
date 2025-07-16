package com.maravilla.commons.dto;


public record ClientesResponse(
		
		Long id_cliente,
		String nombre,
		String apellido,
		String email,
		Long telefono,
		String direccion
		
	
		) {
		
}
