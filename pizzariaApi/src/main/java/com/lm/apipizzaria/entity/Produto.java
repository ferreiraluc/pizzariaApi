package com.lm.apipizzaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Produto extends AbstractEntity {


    @Getter @Setter
    private String sabor;

    @Getter @Setter
    private String produto_item;

    @Getter @Setter
    private int produto_preco;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedido pedidos;

    private Tamanho tamanho;

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Produto() {
    }

    public String getProduto_item() {
        return produto_item;
    }

    public void setProduto_item(String produto_item) {
        this.produto_item = produto_item;
    }

    public int getProduto_preco() {
        return produto_preco;
    }

    public void setProduto_preco(int produto_preco) {
        this.produto_preco = produto_preco;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }



    public Produto(String produto_item, int produto_preco, Pedido pedidos, Tamanho tamanho, String sabor) {
        this.produto_item = produto_item;
        this.produto_preco = produto_preco;
        this.pedidos = pedidos;
        this.tamanho = tamanho;
        this.sabor = sabor;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }


}
