package com.maravilla.servicies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.maravilla.commons.dto.ClientesRequest;
import com.maravilla.commons.dto.ClientesResponse;
import com.maravilla.commons.entities.Clientes;
import com.maravilla.mappers.ClienteMapper;
import com.maravilla.mappers.clienteMapper;
import com.maravilla.repository.ClienteRepository;
import com.maravilla.repository.clienteRepository;

import jakarta.transaction.Transactional;

public class clienteServiceimpl implements clienteServicies{
	
	private clienteRepository repository;
	private clienteMapper mapper;
	private pedidoCliente cliente;	
	
	private void publicCliente(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
		// TODO Auto-generated method stub

	}
	

	@Override
	@Transactional(readOnly = true)
	public List<ClientesResponse> listar() {
		List<ClientesResponse> clientes = new ArrayList<>();
		
		repository.findAll().forEach(cliente ->{
			clientes.add(mapper.entityToResponse(cliente));
		});
		return clientes;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ClientesResponse> obtenerPorId(Long id) {
		Clientes clientes = repository.findById(id).orElseThrow(NoSuchElementException::new);
		return Optional.of(mapper.entityToResponse(clientes));
	}

	@Override
	@Transactional
	public ClientesResponse insertar(ClientesRequest request) {
		<Long> listaClientes = request.Clientes();
		
		if (listaClientes != null && !listaClientes.isEmpty()) {
			for (Long c : listaClientes) {
				this.clientesClient.getCliente(c);
			}
		}
		
		return null;
	}

	@Override
	public ClientesResponse actualizar(ClientesRequest request, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientesResponse eliminar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeProductos(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeCatalogos(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeclientes(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeTipo(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
