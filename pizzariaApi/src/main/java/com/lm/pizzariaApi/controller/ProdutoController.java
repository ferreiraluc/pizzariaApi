package com.lm.pizzariaApi.controller;

import com.lm.pizzariaApi.entity.Produto;
import com.lm.pizzariaApi.repository.ProdutoRepository;
import com.lm.pizzariaApi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.produtoRepository.findById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Produto> produtos = this.produtoRepository.findAll();

        if (produtos.isEmpty()){
            return  ResponseEntity.badRequest().body("Produtos Está Vazia");
        }

        return ResponseEntity.ok().body(produtos);
    }
    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@RequestBody Produto produto){
        try{
            Produto novoProduto = produtoService.criarProduto(produto);
            return  ResponseEntity.ok(novoProduto);
        }   catch (Exception e){
            return  ResponseEntity.badRequest().body("Erro ao Cadastrar Novo Produto");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
        try {
            produtoService.deletarProduto(id);
            return ResponseEntity.ok("Produto deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar produto: " + e.getMessage());
        }
    }
}
