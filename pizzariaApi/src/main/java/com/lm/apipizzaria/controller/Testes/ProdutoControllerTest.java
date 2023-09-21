package com.lm.apipizzaria.controller.testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.apipizzaria.entity.Produto;
import com.lm.apipizzaria.entity.Tamanho;
import com.lm.apipizzaria.repository.ProdutoRepository;
import com.lm.apipizzaria.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void testGetProdutoById() throws Exception {
        Produto produto = new Produto("Pizza de Calabresa", 50, null, Tamanho.P, "Calabresa");

        MvcResult postResult =  mockMvc.perform(post("/api/produto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andReturn();

        Produto produtoCriado = objectMapper.readValue(postResult.getResponse().getContentAsString(), Produto.class);
        Long produtoCriadoId = produtoCriado.getId();

        mockMvc.perform(get("/api/produto/{id}", produtoCriadoId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.produto_item").value(produto.getProdutoitem()))
                .andExpect(jsonPath("$.produto_preco").value(produto.getProdutopreco()))
                .andExpect(jsonPath("$.sabor").value(produto.getSabor()));
    }

    @Test
    public void testGetAllProdutos() throws Exception {
        mockMvc.perform(get("/api/produto"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCadastrarProduto() throws Exception {
        Produto produto = new Produto("NovaPizza", 50, null, Tamanho.P, "Margherita");
        mockMvc.perform(post("/api/produto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.produto_item").value(produto.getProdutoitem()))
                .andExpect(jsonPath("$.produto_preco").value(produto.getProdutopreco()))
                .andExpect(jsonPath("$.sabor").value(produto.getSabor()));
    }

    @Test
    public void testDeletarProduto() throws Exception {
        Produto produto = new Produto("Pizza a ser deletada", 50, null, Tamanho.P, "Quatro Queijos");

        MvcResult postResult =  mockMvc.perform(post("/api/produto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andReturn();

        Produto produtoCriado = objectMapper.readValue(postResult.getResponse().getContentAsString(), Produto.class);
        Long produtoCriadoId = produtoCriado.getId();


        mockMvc.perform(delete("/api/produto/{id}", produtoCriadoId))
                .andExpect(status().isOk())
                .andExpect(content().string("Produto deletado com sucesso"));
    }

    @Test
    public void testAtualizarProduto() throws Exception{
        Produto produto = new Produto("PizzaVelha", 50, null, Tamanho.P, "Lombinho");

        MvcResult postResult =  mockMvc.perform(post("/api/produto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andReturn();

        Produto produtoCriado = objectMapper.readValue(postResult.getResponse().getContentAsString(), Produto.class);
        Long produtoCriadoId = produtoCriado.getId();

        produto.setProdutoitem("PizzaNova");
        produto.setProdutopreco(60);
        produto.setTamanho(Tamanho.M);
        produto.setSabor("Mexicana");
        produto.setPedidos(null);

        mockMvc.perform(put("/api/produto/{id}",produtoCriadoId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk());
    }
}
