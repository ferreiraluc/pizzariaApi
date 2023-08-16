package com.lm.pizzariaApi.entity;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
}
