package com.lm.apipizzaria.controller.testes;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.apipizzaria.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private static final String API_PATH = "/api";
    private static final String CLIENTE_API_PATH = API_PATH + "/cliente";
    private static final String CLIENTE_API_PATH_ID = CLIENTE_API_PATH + "/{id}";


    @Test
    public void clientetestgetall() throws Exception {
        Cliente cliente = new Cliente("Matheus", "9851578514", "Rua Blabla");

        mockMvc.perform(post(CLIENTE_API_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());

        mockMvc.perform(get(CLIENTE_API_PATH))
                .andExpect(status().isOk());
    }

    @Test
    public void clientetestpost() throws Exception {
        Cliente cliente = new Cliente("Bruno", "98452716", "Centro");
        mockMvc.perform(post("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());
    }

    @Test
    public void clientetestdelete() throws Exception {
        Cliente cliente = new Cliente("Carlito", "5192281826", "Bairro");

        MvcResult postResult = mockMvc.perform(post(CLIENTE_API_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andReturn();

        Cliente clienteCriado = objectMapper.readValue(postResult.getResponse().getContentAsString(), Cliente.class);
        Long clienteId = clienteCriado.getId();

        mockMvc.perform(delete(CLIENTE_API_PATH_ID, clienteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void clientetesteput() throws Exception {

        Cliente cliente = new Cliente("Jeorge", "829282999", "AVendia");

        MvcResult postResult = mockMvc.perform(post(CLIENTE_API_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andReturn();

        Cliente clienteCriado = objectMapper.readValue(postResult.getResponse().getContentAsString(), Cliente.class);
        Long clienteId = clienteCriado.getId();


        cliente.setNome("Joao");
        cliente.setTelefone("15481224451");
        cliente.setEndereco("Rua Titi");


                mockMvc.perform(put(CLIENTE_API_PATH_ID, clienteId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());
    }
}