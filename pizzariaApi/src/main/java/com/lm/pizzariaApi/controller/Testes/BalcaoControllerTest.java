package com.lm.pizzariaApi.controller.Testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.pizzariaApi.entity.Funcionario;
import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.service.BalcaoService;
import com.lm.pizzariaApi.service.FuncionarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Collections;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BalcaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BalcaoService balcaoService;

    @MockBean
    private FuncionarioService funcionarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testVisualizarTodosPedidos() throws Exception {
        Pedido pedido = new Pedido();
        given(balcaoService.visualizarTodosPedidos()).willReturn(Arrays.asList(pedido));

        mockMvc.perform(get("/api/balcao/todos-pedidos"))
                .andExpect(status().isOk());
    }

    @Test
    public void testVisualizarPedidosFinalizados() throws Exception {
        Pedido pedido = new Pedido();
        given(balcaoService.visualizarPedidosFinalizados()).willReturn(Arrays.asList(pedido));

        mockMvc.perform(get("/api/balcao/pedidos-finalizados"))
                .andExpect(status().isOk());
    }

    @Test
    public void testVisualizarPedidosPendentes() throws Exception {
        Pedido pedido = new Pedido();
        given(balcaoService.visualizarPedidosPendentes()).willReturn(Arrays.asList(pedido));

        mockMvc.perform(get("/api/balcao/pedidos-pendentes"))
                .andExpect(status().isOk());
    }

    @Test
    public void testVisualizarTodosFuncionarios() throws Exception {
        Funcionario funcionario = new Funcionario();
        given(funcionarioService.getAllFuncionarios()).willReturn(Arrays.asList(funcionario));

        mockMvc.perform(get("/api/balcao/funcionarios"))
                .andExpect(status().isOk());
    }


}
