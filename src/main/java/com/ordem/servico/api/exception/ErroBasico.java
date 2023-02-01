package com.ordem.servico.api.exception;

import java.time.LocalDateTime;

public record ErroBasico(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String path) {
}