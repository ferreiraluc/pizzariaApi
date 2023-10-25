package com.lm.apipizzaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pedidos", schema = "public")
public class Pedido extends AbstractEntity {

    @Getter @Setter
    @Column(name = "pedido_id")
    private Long pedidoid;

    @Getter @Setter
    private String nomepizza;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Getter @Setter
    @Column(name = "produto_id")
    private int produtoid;


    @Getter @Setter
    private String observacao;

    @Getter @Setter
    @Column(name = "funcionario_id")
    private int funcionarioid;

    @Getter @Setter
    private String status;

    @Getter @Setter
    private boolean entrega;



}
