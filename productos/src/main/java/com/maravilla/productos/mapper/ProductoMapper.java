package com.maravilla.productos.mapper;

import org.springframework.stereotype.Component;

import com.maravilla.commons.dto.ProductosRequest;
import com.maravilla.commons.dto.ProductosResponse;
import com.maravilla.commons.entities.Productos;
import com.maravilla.commons.mappers.CommonMapper;

@Component
public class ProductoMapper extends CommonMapper<ProductosRequest, ProductosResponse, Productos>{
	
	@Override
	public ProductosResponse entityToResponse(Productos entity) {
		if (entity == null) {
			return null;
		}
		return new ProductosResponse(entity.getId(), entity.getNombre(), entity.getDescripcion(),
				entity.getPrecio(), entity.getStock());
	}

	@Override
	public Productos requestToEntity(ProductosRequest request) {
		if (request == null) {
			return null;
		}
		
		Productos producto = new Productos();
		producto.setNombre(request.nombre());
		producto.setDescripcion(request.descripcion());
		producto.setPrecio(request.precio());
		producto.setStock(request.stock());
		return producto;
	}

}
