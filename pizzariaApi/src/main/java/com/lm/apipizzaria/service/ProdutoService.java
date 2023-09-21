package com.lm.apipizzaria.service;

import com.lm.apipizzaria.entity.Pedido;
import com.lm.apipizzaria.entity.Produto;
import com.lm.apipizzaria.entity.Tamanho;
import com.lm.apipizzaria.repository.ClienteRepository;
import com.lm.apipizzaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;


    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository,
                          ClienteRepository clienteRepository) {
        this.produtoRepository = produtoRepository;
    }

    public class InvalidPizzaSizeException extends RuntimeException {
        public InvalidPizzaSizeException(String message) {
            super(message);
        }
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto criarProduto(Produto produto) {
        Tamanho tamanho = produto.getTamanho();

        if (tamanho == Tamanho.P) {
            produto.setProdutopreco(50);
            verificarQuantidadeSabores(produto, 1);
        } else if (tamanho == Tamanho.M) {
            produto.setProdutopreco(80);
            verificarQuantidadeSabores(produto, 3);
        } else if (tamanho == Tamanho.GG){
            produto.setProdutopreco(100);
            verificarQuantidadeSabores(produto, 3);
        }
        else {
            throw new InvalidPizzaSizeException("Tamanho de pizza inválido.");
            }


        return produtoRepository.save(produto);
    }

    private void verificarQuantidadeSabores(Produto produto, int quantidadePermitida) {
        String sabor = produto.getSabor();

        if (sabor == null || sabor.isEmpty()) {
            throw new InvalidPizzaSizeException("Você precisa cadastrar pelo menos um sabor.");
        }

        String[] sabores = sabor.split(","); // Suponha que os sabores sejam separados por vírgula
        int quantidadeSabores = sabores.length;

        if (quantidadeSabores != quantidadePermitida) {
            throw new InvalidPizzaSizeException("Número de sabores incorreto para o tamanho da pizza.");
        }
    }

    public void deletarProduto(Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não Encontrado"));
        produtoRepository.delete(produto);
    }

    public Produto atualizarProduto(Long produtoId, String novoSabor, String novoProdutoitem, int novoProdutopreco, Pedido novoPedidos, Tamanho novoTamanho) {

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));


        if (novoSabor != null) {
            produto.setSabor(novoSabor);
        }
        if (novoProdutoitem != null) {
            produto.setProdutoitem(novoProdutoitem);
        }
        if (novoProdutopreco != 0) {
            produto.setProdutopreco(novoProdutopreco);
        }
        if (novoPedidos != null){
            produto.setPedidos(novoPedidos);
        }
        if (novoTamanho != null){
            produto.setTamanho(novoTamanho);
        }


        return produtoRepository.save(produto);
    }

}
