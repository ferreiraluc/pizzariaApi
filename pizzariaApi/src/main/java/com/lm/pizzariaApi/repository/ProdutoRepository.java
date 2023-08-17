package com.lm.pizzariaApi.repository;

import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Override
    Optional<Produto> findById(Long Id);
}
