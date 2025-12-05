package com.talento.crud.repository;

import com.talento.crud.model.Articulo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    
    @Query("SELECT a FROM Articulo a " +
       "LEFT JOIN FETCH a.categoria " +
       "WHERE a.id = :id")
    Optional<Articulo> findByIdWithCategoria(Long id);

    List<Articulo> findAllByCategoriaId(Long categoriaId);
}
