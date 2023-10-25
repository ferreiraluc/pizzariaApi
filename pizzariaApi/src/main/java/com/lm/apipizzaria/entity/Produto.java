package com.lm.apipizzaria.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Produto extends AbstractEntity {


    @Getter @Setter
    private String sabor;

    @JsonProperty("produto_item")
    @Getter @Setter
    private String produtoitem;

    @JsonProperty("produto_preco")
    @Column(name = "produto_preco")
    @Getter @Setter
    private int produtopreco;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedido pedido;

    private Tamanho tamanho;


    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Produto() {
    }

    public String getProdutoitem() {
        return produtoitem;
    }

    public void setProdutoitem(String produtoitem) {
        this.produtoitem = produtoitem;
    }

    public int getProdutopreco() {
        return produtopreco;
    }

    public void setProdutopreco(int produtopreco) {
        this.produtopreco = produtopreco;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }



    public Produto(String produtoitem, int produtopreco, Pedido pedidos, Tamanho tamanho, String sabor) {
        this.produtoitem = produtoitem;
        this.produtopreco = produtopreco;
        this.pedido = pedidos;
        this.tamanho = tamanho;
        this.sabor = sabor;
    }

    public Pedido getPedidos() {
        return pedido;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedido = pedidos;
    }


}
