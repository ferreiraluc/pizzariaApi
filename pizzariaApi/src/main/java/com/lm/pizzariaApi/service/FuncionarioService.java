package com.lm.pizzariaApi.service;

import com.lm.pizzariaApi.entity.Funcionario;
import com.lm.pizzariaApi.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> updateFuncionario(Long id, Funcionario funcionario) {
        return funcionarioRepository.findById(id).map(funcionarioAtualizado -> {
            funcionarioAtualizado.setNome(funcionario.getNome());
            funcionarioAtualizado.setTelefone(funcionario.getTelefone());
            funcionarioAtualizado.setEndereco(funcionario.getEndereco());
            return funcionarioRepository.save(funcionarioAtualizado);
        });
    }

    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
