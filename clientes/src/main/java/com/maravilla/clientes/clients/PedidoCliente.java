package com.maravilla.clientes.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface PedidoCliente {

	@FeignClient(name= "pedido")
	public interface pedidoClient{
		
		@GetMapping("/id-cliente/{id}")
		boolean clienteIsPresent(@PathVariable Long id);
	}
}
