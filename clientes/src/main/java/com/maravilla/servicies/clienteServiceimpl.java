package com.maravilla.servicies;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import com.maravilla.clientes.clients.PedidoCliente;
import com.maravilla.commons.dto.ClientesRequest;
import com.maravilla.commons.dto.ClientesResponse;
import com.maravilla.commons.entities.Clientes;
import com.maravilla.commons.exception.EntidadRelacionadaException;
import com.maravilla.mappers.clienteMapper;
import com.maravilla.repository.clienteRepository;

import jakarta.transaction.Transactional;

public class clienteServiceimpl implements clienteServicies{
	
	private clienteRepository clienteRepository;
	private clienteMapper clienteMapper;
	private PedidoCliente pedidoCliente;	
	
	public clienteServiceimpl(clienteRepository clienteRepository, clienteMapper clienteMapper,
			pedidoCliente pedidoClient) {
		super();
		this.clienteRepository = clienteRepository;
		this.clienteMapper = clienteMapper;
		this.pedidoCliente = pedidoClient;
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
	public ClientesResponse eliminar(Long id) {
		
		Clientes clientes = clienteRepository.findById(id).orElseThrow(NoSuchElementException:: new);
		boolean enUso=PedidoCliente.clienteIsPresent(id);
		
		if (enUso) {
			throw new EntidadRelacionadaException("no se puede eliminar -cliente-, ya que esta asociado a un pedido");
		}else {
			clienteRepository.deleteById(id);
			return clienteMapper.entityToResponse(clientes);
		}
	}

}
