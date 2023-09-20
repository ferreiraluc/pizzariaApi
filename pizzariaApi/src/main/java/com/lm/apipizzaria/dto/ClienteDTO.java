package com.lm.apipizzaria.dto;

import com.lm.apipizzaria.entity.Cliente;

public class ClienteDTO {

    private String nome;
    private String telefone;
    private String endereco;

    public ClienteDTO(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public ClienteDTO(Cliente cliente) {
        nome = cliente.getNome();
        telefone = cliente.getTelefone();
        endereco = cliente.getEndereco();
    }
}