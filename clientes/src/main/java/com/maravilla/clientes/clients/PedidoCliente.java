package com.maravilla.clientes.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pedido")
public interface PedidoCliente {
	
	@GetMapping("/id-cliente/{id}")
	boolean clienteIsPresent(@PathVariable Long id);

}
