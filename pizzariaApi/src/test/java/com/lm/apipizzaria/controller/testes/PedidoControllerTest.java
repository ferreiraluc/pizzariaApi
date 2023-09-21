package com.lm.apipizzaria.controller.testes;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lm.apipizzaria.entity.Pedido;
import com.lm.apipizzaria.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Optional;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PedidoControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PedidoService pedidoService;

    @Test
    void testGetAllPedidos() throws Exception {
        Pedido pedido = new Pedido();
        given(pedidoService.findAll()).willReturn(Arrays.asList(pedido));

        mockMvc.perform(get("/api/pedidos"))
                .andExpect(status().isOk());
    }

    @Test
    void testCreatePedido() throws Exception {
        Pedido newPedido = new Pedido();
        given(pedidoService.save(newPedido)).willReturn(newPedido);

        mockMvc.perform(post("/api/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newPedido)))
                .andExpect(status().isCreated());
    }


    @Test
    void testUpdatePedido() throws Exception {
        Pedido originalPedido = new Pedido();
        Pedido updatedPedido = new Pedido();
        given(pedidoService.findById(1)).willReturn(Optional.of(originalPedido));
        given(pedidoService.save(updatedPedido)).willReturn(updatedPedido);

        mockMvc.perform(put("/api/pedidos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedPedido)))
                .andExpect(status().isOk());
    }


    @Test
    void testDeletePedido() throws Exception {
        Pedido pedidoToDelete = new Pedido();
        given(pedidoService.findById(1)).willReturn(Optional.of(pedidoToDelete));

        mockMvc.perform(delete("/api/pedidos/1"))
                .andExpect(status().isOk());
    }


    @Test
    void testGetPedidosFinalizados() throws Exception {
        Pedido finalizadoPedido = new Pedido();
        given(pedidoService.findPedidosFinalizados()).willReturn(Arrays.asList(finalizadoPedido));

        mockMvc.perform(get("/api/pedidos/finalizados"))
                .andExpect(status().isOk());
    }


}
