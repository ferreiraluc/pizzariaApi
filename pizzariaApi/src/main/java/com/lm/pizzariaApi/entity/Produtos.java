package com.lm.pizzariaApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Produtos extends AbstractEntity {
    @Getter
    @Setter
    private String produto_item;

    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedidos pedidos;

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }


}
