package com.lm.apipizzaria.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Funcionario extends AbstractEntity {

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String telefone;

    @Getter @Setter
    private String endereco;

    public Funcionario(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Funcionario() {}
}