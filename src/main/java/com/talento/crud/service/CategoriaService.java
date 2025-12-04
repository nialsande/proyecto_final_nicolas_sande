package com.talento.crud.service;

import com.talento.crud.model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> listarCategorias();// ToDo - listarCategoriasActivas
    Optional<Categoria> obtenerCategoriaPorId(Long id);
    Categoria guardarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Long id, Categoria categoria);
    Categoria eliminarCategoria(Long id);// ToDo - Baja logica
}
