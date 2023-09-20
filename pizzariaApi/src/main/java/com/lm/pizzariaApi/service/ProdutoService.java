package com.lm.pizzariaApi.service;

import com.lm.pizzariaApi.entity.Cliente;
import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.entity.Produto;
import com.lm.pizzariaApi.entity.Tamanho;
import com.lm.pizzariaApi.repository.ClienteRepository;
import com.lm.pizzariaApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository,
                          ClienteRepository clienteRepository) {
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto criarProduto(Produto produto) {
        Tamanho tamanho = produto.getTamanho();

        if (tamanho == Tamanho.P) {
            produto.setProduto_preco(50);
            verificarQuantidadeSabores(produto, 1);
        } else if (tamanho == Tamanho.M) {
            produto.setProduto_preco(60);
            verificarQuantidadeSabores(produto, 2);
        } else if (tamanho == Tamanho.G) {
            produto.setProduto_preco(80);
            verificarQuantidadeSabores(produto, 3);
        } else if (tamanho == Tamanho.GG){
            produto.setProduto_preco(100);
            verificarQuantidadeSabores(produto, 3);
        }
        else {
            throw new RuntimeException("Tamanho de pizza inválido.");
        }

        return produtoRepository.save(produto);
    }

    private void verificarQuantidadeSabores(Produto produto, int quantidadePermitida) {
        String sabor = produto.getSabor();

        if (sabor == null || sabor.isEmpty()) {
            throw new RuntimeException("Você precisa cadastrar pelo menos um sabor.");
        }

        String[] sabores = sabor.split(","); // Suponha que os sabores sejam separados por vírgula
        int quantidadeSabores = sabores.length;

        if (quantidadeSabores != quantidadePermitida) {
            throw new RuntimeException("Número de sabores incorreto para o tamanho da pizza.");
        }
    }

    public void deletarProduto(Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não Encontrado"));
        produtoRepository.delete(produto);
    }

    public Produto atualizarProduto(Long produtoId, String novoSabor, String novoProduto_item, int novoProduto_preco, Pedido novoPedidos, Tamanho novoTamanho) {

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));


        if (novoSabor != null) {
            produto.setSabor(novoSabor);
        }
        if (novoProduto_item != null) {
            produto.setProduto_item(novoProduto_item);
        }
        if (novoProduto_preco != 0) {
            produto.setProduto_preco(novoProduto_preco);
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
