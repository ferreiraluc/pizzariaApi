package com.lm.pizzariaApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos", schema = "public")
public class Pedidos extends AbstractEntity {
}
