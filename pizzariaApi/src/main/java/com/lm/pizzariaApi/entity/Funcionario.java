package com.lm.pizzariaApi.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Funcionario extends AbstractEntity {
    @Getter
    @Setter
    private String Nome;
    @Getter @Setter
    private String Telefone;
    @Getter @Setter
    private String Endereco;

    public Funcionario(String nome, String telefone, String endereco) {
        Nome = nome;
        Telefone = telefone;
        Endereco = endereco;
    }
    public Funcionario(){}
}
