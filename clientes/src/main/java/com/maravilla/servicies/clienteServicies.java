package com.maravilla.servicies;

import com.maravilla.commons.dto.ClientesRequest;
import com.maravilla.commons.dto.ClientesResponse;
import com.maravilla.commons.services.CommonService;

public interface clienteServicies extends CommonService<ClientesRequest, ClientesResponse>{
	
	boolean existeProductos (Long id);
	
	boolean existeCatalogos (Long id);
	
	boolean existeclientes (Long id);

	boolean existeTipo(Long id);
	
}
