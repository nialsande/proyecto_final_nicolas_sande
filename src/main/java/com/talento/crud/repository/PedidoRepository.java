package com.talento.crud.repository;

import com.talento.crud.model.Pedido;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    // podria ser DTO
    @Query("select p from Pedido p " +
           "left join fetch p.articulos pa " +
           "left join fetch pa.articulo a " +
           "where p.id = :id")
    Optional<Pedido> findByIdWithArticulos(@Param("id") Long id); //filtro
}
