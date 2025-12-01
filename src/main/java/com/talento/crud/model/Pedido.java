package com.talento.crud.model;

import java.time.LocalDate;
// import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // private LocalDate fecha = LocalDate.now();

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PedidoArticulos> articulos;

    public Pedido() {}

    public Pedido(Long id, LocalDate fecha, List<PedidoArticulos> articulos) {
        this.id = id;
        // this.fecha = fecha;
        this.articulos = articulos;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // public LocalDate getFecha() { return fecha; }
    // public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public List<PedidoArticulos> getArticulos() { return articulos; }
    public void setArticulos(List<PedidoArticulos> articulos) { this.articulos = articulos; }
}
