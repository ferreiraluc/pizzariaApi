package com.lm.apipizzaria.controller;
import com.lm.apipizzaria.dto.ResumoPedidosDTO;
import com.lm.apipizzaria.entity.Funcionario;
import com.lm.apipizzaria.entity.Pedido;
import com.lm.apipizzaria.service.BalcaoService;
import com.lm.apipizzaria.service.FuncionarioService;
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

    @GetMapping("/pedidos-pendentes")
    public ResponseEntity<List<Pedido>> visualizarPedidosPendentes() {
        List<Pedido> pendentes = balcaoService.visualizarPedidosPendentes();

        if (pendentes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(pendentes);
    }

    @GetMapping("/pedidos-entregues")
    public ResponseEntity<List<Pedido>> visualizarPedidosEntregues() {
        List<Pedido> entregues = balcaoService.visualizarPedidosEntregues();

        if (entregues.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(entregues);
    }

    @GetMapping("/funcionarios")
    public ResponseEntity<List<Funcionario>> visualizarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios();

        if (funcionarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/resumo-pedidos")
    public ResponseEntity<ResumoPedidosDTO> getResumoPedidos() {
        long pedidosEmAndamento = balcaoService.countPedidosPendentes();
        long pedidosFinalizados = balcaoService.countPedidosFinalizados();

        ResumoPedidosDTO resumo = new ResumoPedidosDTO(pedidosEmAndamento, pedidosFinalizados);
        return ResponseEntity.ok(resumo);
    }





}