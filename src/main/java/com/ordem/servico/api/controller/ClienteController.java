package com.ordem.servico.api.controller;

import com.ordem.servico.api.dto.ClienteAtualizacaoDTO;
import com.ordem.servico.api.dto.ClienteCadastroDTO;
import com.ordem.servico.api.dto.ClienteDetalhesDTO;
import com.ordem.servico.api.mapper.ClienteMapper;
import com.ordem.servico.api.model.Cliente;
import com.ordem.servico.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteDetalhesDTO> cadastrar(@RequestBody @Valid ClienteCadastroDTO dto) {
        Cliente cliente = service.cadastrar(mapper.toEntidade(dto));

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        URI uri = uriComponentsBuilder.path("api/v1/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(mapper.toDetalhesDTO(cliente));
    }

    @PutMapping
    public ResponseEntity<ClienteDetalhesDTO> atualizar(@RequestBody @Valid ClienteAtualizacaoDTO dto) {
        Cliente cliente = service.atualizar(mapper.toEntidade(dto));

        return ResponseEntity.ok(mapper.toDetalhesDTO(cliente));
    }
}
