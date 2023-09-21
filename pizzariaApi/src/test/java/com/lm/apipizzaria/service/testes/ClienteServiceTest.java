package com.lm.apipizzaria.service.testes;

import com.lm.apipizzaria.entity.Cliente;
import com.lm.apipizzaria.repository.ClienteRepository;
import com.lm.apipizzaria.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ClienteServiceTest {

    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    public void testfindclientebyid() {
        Cliente clienteMock = new Cliente();
        clienteMock.setId(1L);
        clienteMock.setNome("João");

        when(clienteRepository.findById(1L)).thenReturn(java.util.Optional.of(clienteMock));

        Cliente resultado = clienteService.buscarporid(1L);

        assertEquals(1L, resultado.getId());
        assertEquals("João", resultado.getNome());
    }
}
