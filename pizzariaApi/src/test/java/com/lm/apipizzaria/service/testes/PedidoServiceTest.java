package com.lm.apipizzaria.service.testes;

import com.lm.apipizzaria.entity.Pedido;
import com.lm.apipizzaria.repository.PedidoRepository;
import com.lm.apipizzaria.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        Pedido pedido = new Pedido(); // Aqui você pode configurar o Pedido conforme necessário
        when(pedidoRepository.findAll()).thenReturn(Collections.singletonList(pedido));

        List<Pedido> result = pedidoService.findAll();

        assertEquals(1, result.size());
        assertEquals(pedido, result.get(0));
    }

    @Test
    void testFindById() {
        Pedido pedido = new Pedido();
        when(pedidoRepository.findById(1)).thenReturn(Optional.of(pedido));

        Optional<Pedido> result = pedidoService.findById(1);

        assertTrue(result.isPresent());
        assertEquals(pedido, result.get());
    }

    @Test
    void testSave() {
        Pedido pedido = new Pedido();
        when(pedidoRepository.save(pedido)).thenReturn(pedido);

        Pedido result = pedidoService.save(pedido);

        assertEquals(pedido, result);
    }

    @Test
    void testDeleteById() {
        pedidoService.deleteById(1);
        verify(pedidoRepository, times(1)).deleteById(1);
    }

    @Test
    void testFindPedidosFinalizados() {
        Pedido pedido = new Pedido();
        when(pedidoRepository.findByStatus("finalizado")).thenReturn(Collections.singletonList(pedido));

        List<Pedido> result = pedidoService.findPedidosFinalizados();

        assertEquals(1, result.size());
        assertEquals(pedido, result.get(0));
    }
}

