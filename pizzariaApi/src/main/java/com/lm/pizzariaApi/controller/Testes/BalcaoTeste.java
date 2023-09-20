package com.lm.pizzariaApi.controller.Testes;

import com.lm.pizzariaApi.controller.BalcaoController;
import com.lm.pizzariaApi.entity.Pedido;
import com.lm.pizzariaApi.service.BalcaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(BalcaoController.class)
public class BalcaoTeste {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BalcaoService balcaoService;

    @BeforeEach
    public void inicializar() {}

    @Test
    public void TesteVisualizarTodosOsPedidos() throws Exception {
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

        when(balcaoService.visualizarTodosPedidos()).thenReturn(pedidosEsperados);

        mockMvc.perform(get("/api/balcao")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // Adicionando uma verificação de conteúdo, assumindo que sua resposta é um JSON do pedido
                .andExpect(content().json("[{\"pedido_ID\":1,\"entrega\":true,\"status\":\"Finalizados\",\"observacao\":\"Observação\",\"cliente_ID\":2,\"funcionario_ID\":3,\"produto_ID\":5}]"));
    }
}
