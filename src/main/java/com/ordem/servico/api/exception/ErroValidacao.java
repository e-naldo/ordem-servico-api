package com.ordem.servico.api.exception;

import org.springframework.validation.FieldError;

public record ErroValidacao(String campo, String mnesagem) {
    public ErroValidacao(FieldError erro) {
        this(erro.getField(), erro.getDefaultMessage());
    }
}
