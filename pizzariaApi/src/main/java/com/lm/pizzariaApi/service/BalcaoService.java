package com.lm.pizzariaApi.service;

import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.repository.PedidoRepository;
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

    // Outros métodos para visualização conforme necessário...
}