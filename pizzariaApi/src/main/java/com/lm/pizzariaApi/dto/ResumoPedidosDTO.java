package com.lm.pizzariaApi.dto;

public class ResumoPedidosDTO {


    private long pedidosEmAndamento;
    private long pedidosFinalizados;

    // Construtor, getters e setters

    public ResumoPedidosDTO(long pedidosEmAndamento, long pedidosFinalizados) {
        this.pedidosEmAndamento = pedidosEmAndamento;
        this.pedidosFinalizados = pedidosFinalizados;
    }

    public long getPedidosEmAndamento() {
        return pedidosEmAndamento;
    }

    public void setPedidosEmAndamento(long pedidosEmAndamento) {
        this.pedidosEmAndamento = pedidosEmAndamento;
    }

    public long getPedidosFinalizados() {
        return pedidosFinalizados;
    }

    public void setPedidosFinalizados(long pedidosFinalizados) {
        this.pedidosFinalizados = pedidosFinalizados;
    }
}
