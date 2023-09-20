package com.lm.apipizzaria.repository;

import com.lm.apipizzaria.entity.Balcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalcaoRepository extends JpaRepository<Balcao, Long> {

}
