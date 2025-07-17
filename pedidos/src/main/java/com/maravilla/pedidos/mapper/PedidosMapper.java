package com.maravilla.pedidos.mapper;


import org.springframework.stereotype.Component;

import com.maravilla.commons.dto.PedidosRequest;
import com.maravilla.commons.dto.PedidosResponse;
import com.maravilla.commons.entities.Pedidos;
import com.maravilla.commons.mappers.CommonMapper;

@Component
public class PedidosMapper extends CommonMapper<PedidosRequest, PedidosResponse, Pedidos>{

	@Override
	public PedidosResponse entityToResponse(Pedidos entity) {
		if(entity== null) {
			return null;
		}
		PedidosResponse pedidosResponse = new PedidosResponse(entity.getId(),
				entity.getIdCliente(), 
				entity.getTotal(),
				entity.getFechaCreacion(), 
				entity.getEstado(),
				entity.getProductos());
		return pedidosResponse;
	}

	@Override
	public Pedidos requestToEntity(PedidosRequest request) {
		if (request == null) {
			return null;
	}
	
	Pedidos pedidos = new Pedidos();
    pedidos.setIdCliente(request.idCliente());
    pedidos.setTotal(request.total());
    pedidos.setFechaCreacion(request.fechaCreacion());
    pedidos.setEstado(request.estado());
    
    return pedidos;
}
}