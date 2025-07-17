package com.maravilla.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maravilla.commons.dto.PedidosRequest;
import com.maravilla.commons.dto.PedidosResponse;
import com.maravilla.commons.entities.Pedidos;
import com.maravilla.mapper.PedidosMapper;
import com.maravilla.pedidos.PedidosApplication;
import com.maravilla.repository.PedidosRepository;

@Service
public class PedidosServiceImpl implements PedidosService{
	private final PedidosApplication pedidosApplication;
	
	private PedidosRepository repository;
	private PedidosMapper mapper;
	
		public PedidosServiceImpl(PedidosRepository pedidosRepository, PedidosMapper pedidosMapper, PedidosApplication pedidosApplication) {
		
		this.repository = pedidosRepository;
		this.mapper = pedidosMapper;
		this.pedidosApplication = pedidosApplication;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PedidosResponse> listar() {
		List<PedidosResponse> pedidos = new ArrayList<>();
		repository.findAll().forEach(pedido ->{
			pedidos.add(mapper.entityToResponse(pedido));
		});
		
		return pedidos;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PedidosResponse> obtenerPorId(Long id) {
		Pedidos pedido = repository.findById(id).orElseThrow(NoSuchElementException::new);
		return Optional.of(mapper.entityToResponse(pedido));
	}

	@Override
	@Transactional
	public PedidosResponse insertar(PedidosRequest request) {
		Pedidos pedido =mapper.requestToEntity(request);
		return mapper.entityToResponse(repository.save(pedido));
	}

	@Override
	@Transactional
	public PedidosResponse actualizar(PedidosRequest request, Long id) {
		Pedidos pedido = repository.findById(id).orElseThrow(NoSuchElementException::new);
		pedido.setEstado(request.estado());
		pedido.setFechaCreacion(request.fechaCreacion());
		pedido.setIdCliente(request.idCliente());
		pedido.setProductos(request.productos());
		pedido.setTotal(request.total());
		
		return mapper.entityToResponse(repository.save(pedido));
	}

	@Override
	@Transactional
	public PedidosResponse eliminar(Long id) {
		Pedidos pedido = repository.findById(id).orElseThrow(NoSuchElementException::new);
		repository.deleteById(id);
		
		return mapper.entityToResponse(pedido);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public boolean existeProducto(Long id) {
		return repository.existeProductoId(id);
	}

}
