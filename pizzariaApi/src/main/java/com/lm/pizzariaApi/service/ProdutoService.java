package com.lm.pizzariaApi.service;

import com.lm.pizzariaApi.entity.Produto;
import com.lm.pizzariaApi.entity.Tamanho;
import com.lm.pizzariaApi.repository.ClienteRepository;
import com.lm.pizzariaApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Produto findById(Long id){return produtoRepository.findById(id).orElse(null);}

    public Produto criarProduto(Produto produto){
        Tamanho tamanho = produto.getTamanho();

        // Definindo o preço com base no tamanho da pizza
        if (tamanho == Tamanho.P) {
            produto.setProduto_preco(50);
            produto.setProduto_item("Sabor único");
        } else if (tamanho == Tamanho.M) {
            produto.setProduto_preco(60);
            produto.setProduto_item("Dois sabores");
        } else if (tamanho == Tamanho.G) {
            produto.setProduto_preco(80);
            produto.setProduto_item("Três sabores");
        } else if (tamanho == Tamanho.GG) {
            produto.setProduto_preco(100);
            produto.setProduto_item("Três sabores");
        }

        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long produtoId){
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não Encontrado"));
        produtoRepository.delete(produto);
    }

}
