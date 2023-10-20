package com.lm.apipizzaria.controller;

import com.lm.apipizzaria.entity.Cliente;
import com.lm.apipizzaria.entity.Pedido;
import com.lm.apipizzaria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int id) {
        return pedidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        try {
            Pedido novoPedido = pedidoService.save(pedido);
            return ResponseEntity.ok(novoPedido);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable int id, @RequestBody Pedido updatedPedido) {
        if (!pedidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedidoService.save(updatedPedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePedido(@PathVariable int id) {
        if (!pedidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pedidoService.deleteById(id);
        return new ResponseEntity<>("Pedido deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/finalizados")
    public ResponseEntity<String> getPedidosFinalizados() {
        List<Pedido> finalizados = pedidoService.findPedidosFinalizados();

        if (finalizados.isEmpty()) {
            return new ResponseEntity<>("Não foi encontrado nenhum pedido", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(finalizados.toString());
    }
}
