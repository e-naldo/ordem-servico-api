package com.ordem.servico.api.mapper;

import com.ordem.servico.api.dto.ClienteAlteracaoDTO;
import com.ordem.servico.api.dto.ClienteCadastroDTO;
import com.ordem.servico.api.dto.ClienteDetalhesDTO;
import com.ordem.servico.api.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntidade(ClienteCadastroDTO dto) {
        return new Cliente(
                dto.nome(),
                dto.documento(),
                dto.email(),
                dto.telefone());
    }

    public Cliente toEntidade(ClienteAlteracaoDTO dto) {
        return new Cliente(
                dto.id(),
                dto.nome(),
                dto.documento(),
                dto.email(),
                dto.telefone());
    }

    public ClienteDetalhesDTO toDetalhesDTO(Cliente cliente) {
        return new ClienteDetalhesDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getDocumento(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getDataCadastro(),
                cliente.getDataAtualizacao()
        );
    }
}
