package com.lm.pizzariaApi.dto;

import com.lm.pizzariaApi.entity.Pedido;

public class PedidoDTO {

    private String observacao;
    private String status;
    private boolean entrega;

    public PedidoDTO(String observacao, String status, boolean entrega){
        this.entrega = entrega;
        this.observacao = observacao;
        this.status = status;
    }
}
