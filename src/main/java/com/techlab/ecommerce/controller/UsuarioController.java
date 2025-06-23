package com.techlab.ecommerce.controller;

import com.techlab.ecommerce.model.Pedido;
import com.techlab.ecommerce.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final PedidoRepository pedidoRepository;

    public UsuarioController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/{id}/pedidos")
    public List<Pedido> getPedidosPorUsuario(@PathVariable Long id) {
        return pedidoRepository.findByUsuarioId(id);
    }
}