package com.maravilla.services;

import org.springframework.stereotype.Service;

import com.maravilla.commons.dto.PedidosRequest;
import com.maravilla.commons.dto.PedidosResponse;
import com.maravilla.commons.services.CommonService;

@Service
public interface PedidosService extends CommonService<PedidosRequest, PedidosResponse>{

	boolean existeProducto(Long id);

}
