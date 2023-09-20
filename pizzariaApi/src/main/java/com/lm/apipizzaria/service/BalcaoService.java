package com.lm.apipizzaria.service;

import com.lm.apipizzaria.entity.Pedido;
import com.lm.apipizzaria.repository.FuncionarioRepository;
import com.lm.apipizzaria.repository.PedidoRepository;
import com.lm.apipizzaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalcaoService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Pedido> visualizarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> visualizarPedidosFinalizados() {
        return pedidoRepository.findByStatus("finalizado");
    }

    public List<Pedido> visualizarPedidosPendentes() {
        return pedidoRepository.findByStatus("pendente");
    }

    public List<Pedido> visualizarPedidosEntregues() {
        return pedidoRepository.findByStatus("entregue");
    }

    public long countPedidosPendentes() {
        return pedidoRepository.countByStatus("pendente");
    }

    public long countPedidosFinalizados() {
        return pedidoRepository.countByStatus("finalizado");
    }


}
