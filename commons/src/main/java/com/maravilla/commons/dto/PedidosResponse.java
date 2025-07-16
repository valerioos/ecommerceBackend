package com.maravilla.commons.dto;


import java.util.Date;
import java.util.List;


public record PedidosResponse(Long id, Long idCliente, Double total, Date fechaCreacion, String estado,
		List<com.maravilla.commons.entities.ProductoPedido> productos) {

}
