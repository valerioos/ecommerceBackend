package com.maravilla.productos.controllers;



import org.springframework.web.bind.annotation.RestController;

import com.maravilla.commons.controllers.CommonController;
import com.maravilla.commons.dto.ProductosRequest;
import com.maravilla.commons.dto.ProductosResponse;
import com.maravilla.productos.services.ProductoService;


@RestController
public class ProductoController extends CommonController<ProductosRequest, ProductosResponse, ProductoService>{

	public ProductoController(ProductoService service) {
		super(service);
	}
	
}
