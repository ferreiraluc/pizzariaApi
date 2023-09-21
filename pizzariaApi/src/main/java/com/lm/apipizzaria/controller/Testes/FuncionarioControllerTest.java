package com.lm.apipizzaria.controller.testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.apipizzaria.entity.Funcionario;
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
public class FuncionarioControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void funcionarioTestGetAll() throws Exception {
        Funcionario funcionario = new Funcionario("Lana", "7895231", "Rua XYZ");

        mockMvc.perform(post("/api/funcionario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/funcionario"))
                .andExpect(status().isOk());
    }

    @Test
    public void funcionarioTestPost() throws Exception {
        Funcionario funcionario = new Funcionario("Lucas", "123456789", "Rua XYZ");

        mockMvc.perform(post("/api/funcionario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isOk());
    }

    @Test
    public void funcionarioTestPut() throws Exception {
        Funcionario funcionario = new Funcionario("Malia", "59452944", "Kennegiy");
        MvcResult result = mockMvc.perform(post("/api/funcionario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isOk())
                .andReturn();

        String responseString = result.getResponse().getContentAsString();
        Funcionario createdFuncionario = objectMapper.readValue(responseString, Funcionario.class);
        Long funcionarioIdToUpdate = createdFuncionario.getId();


        Funcionario updatedFuncionario = new Funcionario("LucasUpdated", "987654321", "Rua ABC");

        mockMvc.perform(put("/api/funcionario/" + funcionarioIdToUpdate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedFuncionario)))
                .andExpect(status().isOk());
    }


    @Test
    public void funcionarioTestDelete() throws Exception {
        // Supondo que o ID do funcionário que você deseja deletar seja 1
        Long funcionarioIdToDelete = 1L;

        mockMvc.perform(delete("/api/funcionario/" + funcionarioIdToDelete))
                .andExpect(status().isOk());
    }
}


