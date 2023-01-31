package com.ordem.servico.api.dto;

import java.time.LocalDateTime;

public record ClienteDetalhesDTO(
        String nome,
        String documento,
        String email,
        String telefone,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao
) {
}
