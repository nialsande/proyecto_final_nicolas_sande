package com.talento.crud.repository;

import com.talento.crud.model.Pedido;

import java.util.Optional;

// Importamos JpaRepository, que nos da los métodos CRUD listos
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// Importamos la anotación @Repository que marca esta interfaz como componente de acceso a datos
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    

    //que es esto ??
    @Query("select p from Pedido p " +
           "left join fetch p.articulos pa " +
           "left join fetch pa.articulo a " +
           "where p.id = :id")
    Optional<Pedido> findByIdWithArticulos(@Param("id") Long id);
}
