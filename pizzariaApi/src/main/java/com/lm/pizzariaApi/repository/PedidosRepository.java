package com.lm.pizzariaApi.repository;

import com.lm.pizzariaApi.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long> {

}
