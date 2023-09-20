package com.lm.pizzariaApi.entity;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    public Long id;
}
