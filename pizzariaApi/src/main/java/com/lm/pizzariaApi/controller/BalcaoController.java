package com.lm.pizzariaApi.controller;

import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.service.BalcaoService;
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
    private BalcaoService balcaoService;

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
}