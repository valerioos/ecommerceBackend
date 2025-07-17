package com.maravilla.clientes.servicies;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.maravilla.clientes.clients.PedidoCliente;
import com.maravilla.commons.dto.ClientesRequest;
import com.maravilla.commons.dto.ClientesResponse;
import com.maravilla.commons.entities.Clientes;
import com.maravilla.commons.exception.EntidadRelacionadaException;
import com.maravilla.clientes.repository.clienteRepository;
import com.maravilla.clientes.mappers.*;

public class clienteServiceimpl implements clienteServicies{
	
	private clienteRepository clienteRepository;
	private clienteMapper clienteMapper;
	private PedidoCliente pedidoCliente;	
	
	public clienteServiceimpl(com.maravilla.clientes.repository.clienteRepository clienteRepository,
			com.maravilla.clientes.mappers.clienteMapper clienteMapper, PedidoCliente pedidoCliente) {
		this.clienteRepository = clienteRepository;
		this.clienteMapper = clienteMapper;
		this.pedidoCliente = pedidoCliente;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClientesResponse> listar() {
		List<ClientesResponse> clientes = new ArrayList<>();
		clienteRepository.findAll().forEach(cliente ->{
			clientes.add(clienteMapper.entityToResponse(cliente));
		});
		return clientes;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ClientesResponse> obtenerPorId(Long id) {
		Clientes clientes = clienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
		return Optional.of(clienteMapper.entityToResponse(clientes));
	}

	@Override
	@Transactional
	public ClientesResponse insertar(ClientesRequest request) {
		Clientes cliente = clienteMapper.requestToEntity(request);
		return clienteMapper.entityToResponse(clienteRepository.save(cliente));
	}

	@Override
	@Transactional
	public ClientesResponse actualizar(ClientesRequest request, Long id) {
		Clientes clientes = clienteRepository.findById(id).orElseThrow(NoSuchElementException:: new);
		clientes.setNombre(request.nombre());
		clientes.setApellido(request.apellido());
		clientes.setEmail(request.email());
		clientes.setTelefono(request.telefono());
		clientes.setDireccion(request.direccion());
		return clienteMapper.entityToResponse(clienteRepository.save(clientes));
	}

	@Override
	@Transactional
	public ClientesResponse eliminar(Long id) {
		
		Clientes cliente = clienteRepository.findById(id).orElseThrow(NoSuchElementException:: new);
		
		boolean enUso = pedidoCliente.clienteIsPresent(id);
		
		if (enUso) {
			throw new EntidadRelacionadaException("No se pudo eliminar el CLIENTE ya que está asociado a un PEDIDO");
		} else {
			clienteRepository.deleteById(id);
			return clienteMapper.entityToResponse(cliente);
		}
		
	}

}
