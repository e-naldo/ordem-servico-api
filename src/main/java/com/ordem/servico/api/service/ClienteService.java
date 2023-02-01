package com.ordem.servico.api.service;

import com.ordem.servico.api.exception.RecursoJaExistenteException;
import com.ordem.servico.api.exception.RecursoNaoEncontradoException;
import com.ordem.servico.api.model.Cliente;
import com.ordem.servico.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente) {

        if (verificarClienteExiste(cliente)) {
            throw new RecursoJaExistenteException("Já existe um Cliente cadastrado com o documento "
                    + cliente.getDocumento());
        }

        cliente.setDataCadastro(LocalDateTime.now());

        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        Cliente clienteAtual = clienteRepository.findById(cliente.getId())
                .orElseThrow(RecursoNaoEncontradoException::new);

        if (verificarClienteExiste(cliente)) {
            throw new RecursoJaExistenteException("Documento já utilizado por outro Cliente");
        }

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
                .orElseThrow(RecursoNaoEncontradoException::new);
    }

    public void excluirPorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public Page<Cliente> buscarTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public boolean verificarClienteExiste(Cliente cliente) {
        Optional<Cliente> clienteEncontrado = clienteRepository.findByDocumento(cliente.getDocumento());

        return clienteEncontrado.isPresent() && !clienteEncontrado.get().getId().equals(cliente.getId());
    }
}
