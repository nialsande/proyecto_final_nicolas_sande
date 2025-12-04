package com.talento.crud.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Boolean estado = true;

    // @OneToMany(mappedBy = "categoria")
    // @JsonManagedReference
    // // @JsonIgnore
    // private List<Articulo> articulos;

    public Categoria() {}

    public Categoria(Long id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
    // public List<Articulo> getArticulos() { return articulos; }
    // public void setArticulos(List<Articulo> articulos) { this.articulos = articulos; }
}
