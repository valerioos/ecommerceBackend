package com.maravilla.mappers;

import org.springframework.stereotype.Component;

import com.maravilla.commons.dto.ClientesRequest;
import com.maravilla.commons.dto.ClientesResponse;
import com.maravilla.commons.entities.Clientes;
import com.maravilla.commons.mappers.CommonMapper;

@Component
public class clienteMapper extends CommonMapper<ClientesRequest, ClientesResponse, Clientes> {

	@Override
	public ClientesResponse entityToResponse(Clientes entity) {
		if (entity == null) {
			return null;
		}
		ClientesResponse clientesResponse=  new ClientesResponse(entity.getId(), 
			entity.getNombre(), entity.getApellido(), entity.getEmail(), entity.getTelefono(), entity.getDireccion());
		return clientesResponse;
	}	
		
	@Override
	public Clientes requestToEntity(ClientesRequest request) {
		if (request == null) {
	
		return null;
		}
		
		Clientes clientes = new Clientes();
		
		clientes.setNombre(request.nombre());
		clientes.setApellido(request.apellido());
		clientes.setEmail(request.email());
		clientes.setTelefono(request.telefono());
		clientes.setDireccion(request.direccion());
		
		return clientes;
	}
	
	
}
