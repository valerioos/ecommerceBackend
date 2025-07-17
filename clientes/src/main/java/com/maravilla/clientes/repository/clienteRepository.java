package com.maravilla.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.maravilla.commons.entities.Clientes;


@Repository
public interface clienteRepository extends JpaRepository<Clientes, Long> {


}
