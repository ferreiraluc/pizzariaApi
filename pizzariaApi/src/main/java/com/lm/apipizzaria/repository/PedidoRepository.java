package com.lm.apipizzaria.repository;

import com.lm.apipizzaria.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {


    List<Pedido> findByStatus(String status);

    long countByStatus(String status);

}
