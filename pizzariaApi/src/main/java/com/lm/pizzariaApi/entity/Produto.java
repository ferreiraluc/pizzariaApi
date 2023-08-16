package com.lm.pizzariaApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Produto extends AbstractEntity {

    @Getter @Setter
    private String produto_item;

    @Getter @Setter
    private int produto_preco;

    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedido pedidos;

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }


}
