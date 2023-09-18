package com.lm.pizzariaApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Balcao",schema = "public")
public class Balcao extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "pedidos_id", referencedColumnName = "id")
    private Pedido pedido;


    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

}