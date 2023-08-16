package com.lm.pizzariaApi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cliente", schema = "public")
public class Cliente extends AbstractEntity {



    @Getter @Setter
    @Column(name = "Nome")
    private String nome;

    @Getter @Setter
    @Column(name = "Telefone")
    private String telefone;

    @Getter @Setter
    @Column(name = "Endereco")
    private String endereco;

    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public Cliente(){}
}
