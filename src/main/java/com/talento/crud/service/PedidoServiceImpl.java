package com.talento.crud.service;

import com.talento.crud.model.Pedido;
import com.talento.crud.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        // return pedidoRepository.save(pedido);
        if (pedido.getArticulos() != null) {
            pedido.getArticulos().forEach(pa -> pa.setPedido(pedido));
        }

        Pedido saved = pedidoRepository.save(pedido);

        // ahora buscar con fetch join para devolver objeto completamente inicializado
        return pedidoRepository.findByIdWithArticulos(saved.getId())
                .orElse(saved); // fallback por las dudas
    }

    @Override
    public Pedido actualizarPedido(Long id, Pedido pedido) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
