package com.lm.pizzariaApi.controller.Testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.pizzariaApi.controller.BalcaoController;
import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.service.BalcaoService;
import com.lm.pizzariaApi.service.PedidoService;
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

import static org.springframework.boot.autoconfigure.AutoConfigurationPackages.has;

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
        List<Pedido> pedidosEsperados = new ArrayList<>();

        Pedido pedido1 = new Pedido();

        pedido1.setPedido_ID(1L);
        pedido1.setEntrega(true);
        pedido1.setStatus("Finalizados");
        pedido1.setObservacao("Observação");
        pedido1.setCliente_ID(2);
        pedido1.setFuncionario_ID(3);
        pedido1.setProduto_ID(5);

        pedidosEsperados.add(pedido1);

        Mockito.when(balcaoService.visualizarTodosPedidos()).thenReturn(pedidosEsperados);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/balcao")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
