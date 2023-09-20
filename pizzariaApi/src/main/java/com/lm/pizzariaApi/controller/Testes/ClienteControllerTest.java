package com.lm.pizzariaApi.controller.Testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.pizzariaApi.entity.Cliente;
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

    @Test
    public void ClienteTestGetAll() throws Exception {
        Cliente cliente = new Cliente("Matheus", "9851578514", "Rua Blabla");

        mockMvc.perform(post("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/cliente"))
                .andExpect(status().isOk());
    }

    @Test
    public void clienteTestPost() throws Exception {
        Cliente cliente = new Cliente("Matheus", "9851578514", "Rua Blabla");
        mockMvc.perform(post("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());
    }

    @Test
    public void clienteTestDelete() throws Exception {
        Cliente cliente = new Cliente("Jeorge", "123456789", "Rua Tete");

        MvcResult postResult = mockMvc.perform(post("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andReturn();

        Cliente clienteCriado = objectMapper.readValue(postResult.getResponse().getContentAsString(), Cliente.class);
        Long clienteId = clienteCriado.getId();

        mockMvc.perform(delete("/api/cliente/{id}", clienteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void clienteTestPut() throws Exception {

        Cliente cliente = new Cliente("Jeorge", "123456789", "Rua Tete");

        MvcResult postResult = mockMvc.perform(post("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andReturn();

        Cliente clienteCriado = objectMapper.readValue(postResult.getResponse().getContentAsString(), Cliente.class);
        Long clienteId = clienteCriado.getId();


        cliente.setNome("Joao");
        cliente.setTelefone("15481224451");
        cliente.setEndereco("Rua Titi");


                mockMvc.perform(put("/api/cliente/{id}", clienteId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());
    }
}