package com.lm.pizzariaApi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lm.pizzariaApi.entity.Cliente;
import com.lm.pizzariaApi.repository.ClienteRepository;
import com.lm.pizzariaApi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarPorID(@PathVariable Long id){
        return  ResponseEntity.ok().body(this.clienteService.BuscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Cliente> clientes = this.clienteRepository.findAll();

        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body("Ok");
    }
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
        try {
            Cliente novoCliente = clienteService.CriarCliente(cliente);
            return ResponseEntity.ok(novoCliente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente.getNome(), cliente.getTelefone(), cliente.getEndereco());
            return ResponseEntity.ok(clienteAtualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar cliente: " + e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            clienteService.deletarCliente(id);
            return ResponseEntity.ok("Cliente deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar cliente: " + e.getMessage());
        }
    }
}


