package com.ordem.servico.api.service;

import com.ordem.servico.api.model.Cliente;
import com.ordem.servico.api.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente){
        cliente.setDataCadastro(LocalDateTime.now());

        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente){
        Cliente clienteAtual = clienteRepository.findById(cliente.getId())
                .orElseThrow(EntityNotFoundException::new);

        clienteAtual.setNome(cliente.getNome());
        clienteAtual.setDocumento(cliente.getDocumento());
        clienteAtual.setEmail(cliente.getEmail());
        clienteAtual.setTelefone(cliente.getTelefone());
        clienteAtual.setDataAtualizacao(LocalDateTime.now());

        clienteRepository.save(clienteAtual);

        return clienteAtual;
    }

    public Cliente buscarPorid(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public void excluirPorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public Page<Cliente> buscarTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }
}
