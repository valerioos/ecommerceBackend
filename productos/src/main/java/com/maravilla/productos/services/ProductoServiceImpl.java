package com.maravilla.productos.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maravilla.commons.dto.ProductosRequest;
import com.maravilla.commons.dto.ProductosResponse;
import com.maravilla.commons.entities.Productos;
import com.maravilla.commons.exception.EntidadRelacionadaException;
import com.maravilla.productos.clients.PedidoCliente;
import com.maravilla.productos.mapper.ProductoMapper;
import com.maravilla.productos.repositories.ProductoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ProductoServiceImpl implements ProductoService{

	private ProductoRepository repository;
	
	private PedidoCliente pedidoCliente;
	
	private ProductoMapper mapper;
	

	public ProductoServiceImpl(ProductoRepository repository, PedidoCliente pedidoCliente, ProductoMapper mapper) {
		this.repository = repository;
		this.pedidoCliente = pedidoCliente;
		this.mapper = mapper;
	}

	@Override
	public List<ProductosResponse> listar() {
		List<ProductosResponse> productos = new ArrayList<>();
		repository.findAll().forEach(producto -> {
			productos.add(mapper.entityToResponse(producto));
		});
		return productos;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ProductosResponse> obtenerPorId(Long id) {
		Productos producto = repository.findById(id).orElseThrow(NoSuchElementException::new);
		return Optional.of(mapper.entityToResponse(producto));
	}

	@Override
	@Transactional
	public ProductosResponse insertar(ProductosRequest request) {
		Productos producto = mapper.requestToEntity(request);
		return mapper.entityToResponse(repository.save(producto));
	}

	@Override
	@Transactional
	public ProductosResponse actualizar(ProductosRequest request, Long id) {
		Productos producto = repository.findById(id).orElseThrow(NoSuchElementException::new);
		producto.setNombre(request.nombre());
		producto.setDescripcion(request.descripcion());
		producto.setPrecio(request.precio());
		producto.setStock(request.stock());
		return mapper.entityToResponse(repository.save(producto));
	}

	@Override
	@Transactional
	public ProductosResponse eliminar(Long id) {
		Productos producto = repository.findById(id).orElseThrow(NoSuchElementException::new);
		
		boolean enUso = pedidoCliente.productoIsPresent(id);
		if(enUso) {
			throw new EntidadRelacionadaException("No se puede eliminar el producto por que esta en un producto relacionado.");
		}
		else {
			repository.deleteById(id);
			return mapper.entityToResponse(producto);
		}
		
	}
	
}
