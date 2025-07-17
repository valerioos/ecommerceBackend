package com.maravilla.services;

import com.maravilla.commons.dto.PedidosRequest;
import com.maravilla.commons.dto.PedidosResponse;
import com.maravilla.commons.services.CommonService;

public interface PedidosService extends CommonService<PedidosRequest, PedidosResponse>{

	boolean existeProducto(Long id);

}
