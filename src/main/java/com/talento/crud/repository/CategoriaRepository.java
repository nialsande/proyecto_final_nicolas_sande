package com.talento.crud.repository;

import com.talento.crud.model.Categoria;

// Importamos JpaRepository, que nos da los métodos CRUD listos
import org.springframework.data.jpa.repository.JpaRepository;

// Importamos la anotación @Repository que marca esta interfaz como componente de acceso a datos
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
