package com.lm.pizzariaApi.service;

import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.entity.Produto;
import com.lm.pizzariaApi.repository.PedidoRepository;
import com.lm.pizzariaApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class BalcaoService {

    private static final Logger logger = LoggerFactory.getLogger(BalcaoService.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Pedido> visualizarTodosPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        logger.info("Visualizando todos os pedidos: {}", pedidos);
        return pedidos;
    }

    public List<Pedido> visualizarPedidosFinalizados() {
        List<Pedido> finalizados = pedidoRepository.findByStatus("finalizados");
        if (finalizados.isEmpty()) {
            logger.info("Não foi encontrado nenhum pedido finalizado.");
        } else {
            logger.info("Visualizando pedidos finalizados: {}", finalizados);
        }
        return finalizados;
    }

    public List<Pedido> visualizarPedidosPendentes() {
        List<Pedido> pendentes = pedidoRepository.findByStatus("pendente");
        if (pendentes.isEmpty()) {
            logger.info("Não foi encontrado nenhum pedido pendente.");
        } else {
            logger.info("Visualizando pedidos pendentes: {}", pendentes);
        }
        return pendentes;
    }

    public List<Pedido> visualizarPedidosEntregues() {
        List<Pedido> entregues = pedidoRepository.findByStatus("entregue");
        if (entregues.isEmpty()) {
            logger.info("Não foi encontrado nenhum pedido entregue.");
        } else {
            logger.info("Visualizando pedidos entregues: {}", entregues);
        }
        return entregues;
    }



    // Outros métodos para visualização conforme necessário...
}