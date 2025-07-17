package com.maravilla.productos.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.maravilla.commons.entities.Productos;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Long>{

}
