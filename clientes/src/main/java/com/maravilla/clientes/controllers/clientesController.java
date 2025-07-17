package com.maravilla.clientes.controllers;


import org.springframework.web.bind.annotation.RestController;

import com.maravilla.clientes.servicies.clienteServicies;
import com.maravilla.commons.controllers.CommonController;
import com.maravilla.commons.dto.ClientesRequest;
import com.maravilla.commons.dto.ClientesResponse;

@RestController
public class clientesController extends CommonController<ClientesRequest, ClientesResponse, clienteServicies> {

	 public clientesController (clienteServicies service) {
		 super (service);
	 }
	 
}