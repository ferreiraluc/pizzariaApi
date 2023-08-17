package com.lm.pizzariaApi.service;

import com.lm.pizzariaApi.entity.Produto;
import com.lm.pizzariaApi.entity.Tamanho;
import com.lm.pizzariaApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto BuscarPorId(Long id){return produtoRepository.findById(id).orElse(null);}

    public void DeletarProduto(Long produtoId){
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto Não Encontrado"));
        produtoRepository.delete(produto);
    }

    public Produto CriarProduto(Produto produto){
        if (produto.getTamanho() == Tamanho.valueOf("P")){
            produto.setProduto_preco(50);
        }
        if (produto.getTamanho() == Tamanho.valueOf("M")){
            produto.setProduto_preco(70);
        }
        if (produto.getTamanho() == Tamanho.valueOf("G")){
            produto.setProduto_preco(85);
        }
        if (produto.getTamanho() == Tamanho.valueOf("GG")){
            produto.setProduto_preco(100);
        }
        return null;
    }

}
