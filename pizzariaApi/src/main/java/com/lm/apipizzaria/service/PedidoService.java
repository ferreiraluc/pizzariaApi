package com.lm.apipizzaria.service;
import com.lm.apipizzaria.entity.Pedido;
import com.lm.apipizzaria.entity.Produto;
import com.lm.apipizzaria.repository.PedidoRepository;
import com.lm.apipizzaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(int id) {
        return pedidoRepository.findById(id);
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deleteById(int id) {
        pedidoRepository.deleteById(id);
    }

    public List<Pedido> findPedidosFinalizados() {
        return pedidoRepository.findByStatus("finalizado");
    }






}
