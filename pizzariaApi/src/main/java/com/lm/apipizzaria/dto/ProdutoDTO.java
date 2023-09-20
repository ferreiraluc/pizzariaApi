package com.lm.apipizzaria.dto;

public class ProdutoDTO {

    private String sabor;
    private String produto_item;
    private int produto_preco;

    public ProdutoDTO(String sabor, String produto_item, int produto_preco){
        this.produto_item = produto_item;
        this.produto_preco = produto_preco;
        this.sabor = sabor;
    }
}
