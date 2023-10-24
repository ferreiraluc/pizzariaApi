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

    @Getter @Setter
    @Column(name = "produto_id")
    private int produtoid;

    @Column(name = "cliente_id")
    @Getter @Setter
    private int clienteid;
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
