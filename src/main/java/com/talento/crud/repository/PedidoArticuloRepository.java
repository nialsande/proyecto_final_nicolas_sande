package com.talento.crud.repository;

import com.talento.crud.model.PedidoArticulos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoArticuloRepository extends JpaRepository<PedidoArticulos, Long> {

}