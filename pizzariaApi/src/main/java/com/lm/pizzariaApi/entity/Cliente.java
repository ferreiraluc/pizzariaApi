package com.lm.pizzariaApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cliente", schema = "public")
public class Cliente extends AbastractEntity {

    @Getter @Setter
    private int Cliente_ID;
    @Getter @Setter
    private String Nome;
    @Getter @Setter
    private String Telefone;
    @Getter @Setter
    private String Endereco;


}
