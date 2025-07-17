package com.maravilla.pedidos.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.maravilla.commons.controllers.CommonController;
import com.maravilla.commons.dto.PedidosRequest;
import com.maravilla.commons.dto.PedidosResponse;
import com.maravilla.pedidos.services.PedidosService;

@RestController
public class PedidosController extends CommonController<PedidosRequest, PedidosResponse, PedidosService>{

	public PedidosController(PedidosService service) {
		
	super(service);
	}
	
	@GetMapping("/id-producto/{id}")
	public ResponseEntity<Boolean> productoIsPresent(@PathVariable Long id) {
		boolean isPresent = service.existeProducto(id);
		return ResponseEntity.ok(isPresent);
	}

}
