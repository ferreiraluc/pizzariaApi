package com.lm.pizzariaApi.controller.Testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.pizzariaApi.controller.BalcaoController;
import com.lm.pizzariaApi.controller.ClienteController;
import com.lm.pizzariaApi.entity.Cliente;
import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.service.BalcaoService;
import com.lm.pizzariaApi.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(BalcaoController.class)
public class ClienteTeste {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private ClienteController clienteController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void inicializar(){}

    @Test
    public void TesteFindAll()throws Exception{
        List<Cliente> clienteEsperado = new ArrayList<>();

        Cliente cliente1 = new Cliente();

        cliente1.setEndereco("Rua blabla");
        cliente1.setNome("Matheus");
        cliente1.setTelefone("988284015");

        clienteEsperado.add(cliente1);

       Mockito.when(clienteController.findAll()).thenReturn(clienteEsperado);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/cliente")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
