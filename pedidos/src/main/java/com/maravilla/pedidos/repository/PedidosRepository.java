package com.maravilla.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maravilla.commons.entities.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long>{

	@Query("SELECT COUNT(p) > 0 FROM Pedidos p JOIN p.productos pr WHERE pr.idProducto = :idProducto")
	boolean existeProductoId(@Param("idProducto") Long idProducto);

	
}
