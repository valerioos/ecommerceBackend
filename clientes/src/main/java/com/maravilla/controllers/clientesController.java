package com.maravilla.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.maravilla.commons.controllers.CommonController;
import com.maravilla.commons.dto.ClientesRequest;
import com.maravilla.commons.dto.ClientesResponse;
import com.maravilla.servicies.clienteServicies;

@RestController
public class clientesController extends CommonController<ClientesRequest, ClientesResponse, clienteServicies> {

	 public clientesController (clienteServicies service) {
		 super (service);
	 }
	 
	 @GetMapping("/id-clientes/{id}")
	 public ResponseEntity<Boolean>clientesIsPresent(@PathVariable Long id){
			boolean isPresent = service.existeTipo(id);
			return ResponseEntity.ok(isPresent);
}
}