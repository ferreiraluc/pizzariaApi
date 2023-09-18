package com.lm.pizzariaApi.controller.Testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.pizzariaApi.controller.BalcaoController;
import com.lm.pizzariaApi.service.BalcaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BalcaoController.class)
public class BalcaoTeste {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BalcaoService balcaoService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void inicializar(){}

    @Test
    public void TesteVisualizarTodosOsPedidos()throws Exception{

    }
}
