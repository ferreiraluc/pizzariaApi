package com.lm.pizzariaApi.repository;

import com.lm.pizzariaApi.entity.Balcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalcaoRepository extends JpaRepository<Balcao, Long> {

}
