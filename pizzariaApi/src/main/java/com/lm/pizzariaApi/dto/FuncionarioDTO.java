package com.lm.pizzariaApi.dto;

public class FuncionarioDTO {

    private String nome;
    private String telefone;
    private String endereco;

    public FuncionarioDTO(String nome, String telefone, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
