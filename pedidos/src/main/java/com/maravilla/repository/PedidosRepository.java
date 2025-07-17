package com.maravilla.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maravilla.commons.entities.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long>{

}
