package com.lm.apipizzaria.controller;

import com.lm.apipizzaria.entity.Produto;
import com.lm.apipizzaria.repository.ProdutoRepository;
import com.lm.apipizzaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.produtoRepository.findById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> produtos = this.produtoRepository.findAll();

        if (produtos.isEmpty()){
            return  ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok().body(produtos);
    }
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
        try{
            Produto novoProduto = produtoService.criarProduto(produto);
            return  ResponseEntity.ok(novoProduto);
        }   catch (Exception e){
            return  ResponseEntity.badRequest().body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        try {
            produtoService.deletarProduto(id);
            return ResponseEntity.ok("Produto deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar produto: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        try {
            Produto produtoAtualizado = produtoService.atualizarProduto(id, produto.getProdutoitem(), produto.getSabor(), produto.getProdutopreco(), produto.getPedidos(), produto.getTamanho());
            return ResponseEntity.ok(produtoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
