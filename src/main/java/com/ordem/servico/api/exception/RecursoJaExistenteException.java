package com.ordem.servico.api.exception;

import jakarta.persistence.EntityExistsException;

public class RecursoJaExistenteException extends EntityExistsException {
    public RecursoJaExistenteException() {
        super("Recurso já existe");
    }

    public RecursoJaExistenteException(String message) {
        super(message);
    }
}
