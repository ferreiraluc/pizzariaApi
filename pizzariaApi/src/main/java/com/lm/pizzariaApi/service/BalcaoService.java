package com.lm.pizzariaApi.service;

import com.lm.pizzariaApi.entity.Funcionario;
import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.entity.Produto;
import com.lm.pizzariaApi.repository.FuncionarioRepository;
import com.lm.pizzariaApi.repository.PedidoRepository;
import com.lm.pizzariaApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

}
