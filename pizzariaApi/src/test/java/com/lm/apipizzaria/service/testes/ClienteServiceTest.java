package com.lm.apipizzaria.service.testes;

import com.lm.apipizzaria.entity.Cliente;
import com.lm.apipizzaria.repository.ClienteRepository;
import com.lm.apipizzaria.service.ClienteService;
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

class ClienteServiceTest {

    @InjectMocks
    ClienteService clienteService;

    @Mock
    ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBuscarporid() {
        Cliente cliente = new Cliente();
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente result = clienteService.buscarporid(1L);

        assertEquals(cliente, result);
    }

    @Test
    void testCriarcliente() {
        Cliente cliente = new Cliente();
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.criarcliente(cliente);

        assertEquals(cliente, result);
    }

    @Test
    void testListarTodosClientes() {
        Cliente cliente = new Cliente();
        List<Cliente> clienteList = Collections.singletonList(cliente);
        when(clienteRepository.findAll()).thenReturn(clienteList);

        List<Cliente> results = clienteService.listarTodosClientes();

        assertEquals(clienteList.size(), results.size());
        assertEquals(clienteList.get(0), results.get(0));
    }


    @Test
    void testDeletarcliente() {
        Cliente cliente = new Cliente();
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        clienteService.deletarcliente(1L);

        verify(clienteRepository).delete(cliente);
    }
}
