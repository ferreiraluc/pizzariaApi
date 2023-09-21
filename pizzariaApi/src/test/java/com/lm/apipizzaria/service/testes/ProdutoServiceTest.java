package com.lm.apipizzaria.service.testes;

import com.lm.apipizzaria.entity.Pedido;
import com.lm.apipizzaria.entity.Produto;
import com.lm.apipizzaria.entity.Tamanho;
import com.lm.apipizzaria.repository.ProdutoRepository;
import com.lm.apipizzaria.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Produto produto = new Produto();
        produto.setSabor("Queijo");
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Produto result = produtoService.findById(1L);

        assertNotNull(result);
        assertEquals(produto, result);
    }

    @Test
    void testCriarProdutoSizeP() {
        Produto produto = new Produto();
        produto.setTamanho(Tamanho.P);
        produto.setSabor("Queijo");

        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto result = produtoService.criarProduto(produto);

        assertNotNull(result);
        assertEquals(50, result.getProdutopreco());
    }

    @Test
    void testCriarProdutoInvalidSize() {
        Produto produto = new Produto();
        produto.setTamanho(Tamanho.G);

        assertThrows(ProdutoService.InvalidPizzaSizeException.class, () -> {
            produtoService.criarProduto(produto);
        });
    }

    @Test
    void testDeletarProduto() {
        Produto produto = new Produto();
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        produtoService.deletarProduto(1L);

        verify(produtoRepository, times(1)).delete(produto);
    }

    @Test
    void testAtualizarProduto() {
        Produto produto = new Produto();
        String novoSabor = "Calabresa";
        String novoProdutoitem = "Item 2";
        int novoProdutopreco = 90;
        Pedido novoPedidos = new Pedido();
        Tamanho novoTamanho = Tamanho.M;

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto result = produtoService.atualizarProduto(1L, novoSabor, novoProdutoitem, novoProdutopreco, novoPedidos, novoTamanho);

        assertNotNull(result);
        assertEquals(novoSabor, result.getSabor());
        assertEquals(novoProdutoitem, result.getProdutoitem());
        assertEquals(novoProdutopreco, result.getProdutopreco());
        assertEquals(novoPedidos, result.getPedidos());
        assertEquals(novoTamanho, result.getTamanho());
    }
}
