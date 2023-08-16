package com.lm.pizzariaApi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidos", schema = "public")
public class Pedido extends AbstractEntity {

    @Getter @Setter
    @Column(name = "pedido_id")
    private int pedido_ID;


    @Getter @Setter
    @Column(name = "produto_id")
    private int produto_ID;

    @Column(name = "cliente_id")
    @Getter @Setter
    private int cliente_ID;

    @Getter @Setter
    private String observacao;

    @Getter @Setter
    @Column(name = "funcionario_id")
    private int funcionario_ID;

    @Getter @Setter
    private String status;

    @Getter @Setter
    private boolean entrega;


}
