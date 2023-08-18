package com.lm.pizzariaApi.service;

import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalcaoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> visualizarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> visualizarPedidosFinalizados() {
        return pedidoRepository.findByStatus("finalizados");
    }

    // Outros métodos para visualização conforme necessário...
}