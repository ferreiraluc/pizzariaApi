package com.lm.pizzariaApi.controller.Testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.pizzariaApi.controller.ClienteController;
import com.lm.pizzariaApi.entity.Cliente;
import com.lm.pizzariaApi.repository.ClienteRepository;
import com.lm.pizzariaApi.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ClienteRepository clienteRepository;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {}

    @Test
    public void testFindAllClientes() throws Exception {

        List<Cliente> clientesEsperados = new ArrayList<>();
        Cliente cliente1 = new Cliente();
        cliente1.setEndereco("Rua blabla");
        cliente1.setNome("Matheus");
        cliente1.setTelefone("988284015");

        clientesEsperados.add(cliente1);


        Mockito.when(clienteService.findAll()).thenReturn(clientesEsperados);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"nome\": \"Matheus\", \"endereco\": \"Rua blabla\", \"telefone\": \"988284015\"}"));


    }
}
