package com.lm.pizzariaApi.controller;
import com.lm.pizzariaApi.entity.Funcionario;
import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.entity.Produto;
import com.lm.pizzariaApi.service.BalcaoService;
import com.lm.pizzariaApi.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/balcao")
public class BalcaoController {

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private BalcaoService balcaoService;

    @GetMapping("")
    public ResponseEntity<List<Pedido>> verPedidos() {
        return ResponseEntity.ok(balcaoService.visualizarTodosPedidos());
    }



    @GetMapping("/todos-pedidos")
    public ResponseEntity<List<Pedido>> visualizarTodosPedidos() {
        return ResponseEntity.ok(balcaoService.visualizarTodosPedidos());
    }

    @GetMapping("/pedidos-finalizados")
    public ResponseEntity<List<Pedido>> visualizarPedidosFinalizados() {
        List<Pedido> finalizados = balcaoService.visualizarPedidosFinalizados();

        if (finalizados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(finalizados);
    }

    @GetMapping("/funcionarios")
    public ResponseEntity<List<Funcionario>> visualizarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios();

        if (funcionarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(funcionarios);
    }



}