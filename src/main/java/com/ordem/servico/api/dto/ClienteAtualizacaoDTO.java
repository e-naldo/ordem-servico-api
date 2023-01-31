package com.ordem.servico.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteAtualizacaoDTO(
        @NotNull
        Long id,
        @NotBlank
        @Size(min = 3, max = 150)
        String nome,
        @NotBlank
        @Size(min = 11, max = 14)
        String documento,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 10, max = 11)
        String telefone
) {
}
