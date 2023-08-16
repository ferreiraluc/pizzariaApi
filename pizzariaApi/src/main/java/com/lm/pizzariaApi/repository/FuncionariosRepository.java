package com.lm.pizzariaApi.repository;

import com.lm.pizzariaApi.entity.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {

}
