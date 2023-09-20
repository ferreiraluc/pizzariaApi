package com.lm.apipizzaria.controller;


import com.lm.apipizzaria.entity.Funcionario;
import com.lm.apipizzaria.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> getAllFuncionarios(){
        return funcionarioRepository.findAll();

    }

    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Funcionario saveFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
        return funcionarioRepository.findById(id).map(funcionarioAtualizado -> {
            funcionarioAtualizado.setNome(funcionario.getNome());
            funcionarioAtualizado.setTelefone(funcionario.getTelefone());
            funcionarioAtualizado.setEndereco(funcionario.getEndereco());
            return funcionarioRepository.save(funcionarioAtualizado);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFuncionario(@PathVariable Long id){
        try {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.ok("Funcionario deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar funcionário: " + e.getMessage());
        }
    }



}
