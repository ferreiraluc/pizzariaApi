package com.lm.pizzariaApi.service;

import com.lm.pizzariaApi.entity.Cliente;
import com.lm.pizzariaApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente BuscarPorId(Long id){return clienteRepository.findById(id).orElse(null);}

    public Cliente CriarCliente(Cliente cliente){return clienteRepository.save(cliente);}

    public Cliente atualizarCliente(Long clienteId, String novoNome, String novoTelefone, String novoEndereco) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));


        if (novoNome != null) {
            cliente.setNome(novoNome);
        }
        if (novoTelefone != null) {
            cliente.setTelefone(novoTelefone);
        }
        if (novoEndereco != null) {
            cliente.setEndereco(novoEndereco);
        }


        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }
}
