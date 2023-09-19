package com.lm.pizzariaApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.pizzariaApi.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        // Crie um cliente com dados válidos
        Cliente cliente = new Cliente("Matheus", "9851578514","Rua Blabla");

        mockMvc.perform(post("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                        .andExpect(status().isOk());

        mockMvc.perform(get("/api/cliente"))
                .andExpect(status().isOk());
    }

    @Test
    public void clienteTestPost() throws Exception{
        Cliente cliente = new Cliente("Matheus", "9851578514","Rua Blabla");
        mockMvc.perform(post("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());
    }

    @Test
    public void clienteTestDelete() throws Exception{

    }
}
