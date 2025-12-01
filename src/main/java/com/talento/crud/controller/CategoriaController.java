package com.talento.crud.controller;

import com.talento.crud.model.Categoria;
import com.talento.crud.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Long id) {
        return categoriaService.obtenerCategoriaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria articulo) {
        return categoriaService.guardarCategoria(articulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria articulo) {
        if (categoriaService.obtenerCategoriaPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaService.actualizarCategoria(id, articulo));
    }

    // ToDo - deberia cambiar de estado.
    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> eliminar(@PathVariable Long id, @RequestBody Categoria articulo) {
        if (categoriaService.obtenerCategoriaPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaService.actualizarCategoria(id, articulo));
    }
}
