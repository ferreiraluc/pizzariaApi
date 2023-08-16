package com.lm.pizzariaApi.repository;

import com.lm.pizzariaApi.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionario, Long> {

}
